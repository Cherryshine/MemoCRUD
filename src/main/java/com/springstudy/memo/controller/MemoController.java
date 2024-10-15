package com.springstudy.memo.controller;


import com.springstudy.memo.dto.MemoRequestDto;
import com.springstudy.memo.dto.MemoResponseDto;
import com.springstudy.memo.entity.MemoEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api")
public class MemoController {
    private final Map<Long, MemoEntity> memoList = new HashMap<>();

    @PostMapping("/memos")
    public MemoResponseDto createMemo(@RequestBody MemoRequestDto requestDto){

        MemoEntity memo = new MemoEntity(requestDto);

        //memo max id check
        Long maxId = memoList.size() > 0 ? Collections.max(memoList.keySet()) + 1 : 1;
        memo.setId(maxId);

        //Map에 저장
        memoList.put(memo.getId(), memo);

        // Entity -> ResponseDto
        MemoResponseDto memoResponseDto = new MemoResponseDto(memo);

        return memoResponseDto;
    }


    @GetMapping ("/memos")
    public List<MemoResponseDto> getMemos(){
        //Map to List
        List<MemoResponseDto> responseList = memoList.values().stream()
                .map(MemoResponseDto::new).toList();

        return responseList;
    }


    @PutMapping("/memos/{id}")
    public Long updateMemo(@PathVariable Long id, @RequestBody MemoRequestDto requestDto){
        // 해당 메모가 데이터베이스에 존재하는지 확인
        if (memoList.containsKey(id)) {
            // 해당메모 가져오기
            MemoEntity memo = memoList.get(id);

            //메모 수정
            memo.update(requestDto);
            return memo.getId();
        } else {
            throw new IllegalArgumentException("선택한 메모가 존재하지 않습니다.");
        }

    }


    @DeleteMapping("/memos/{id}")
    public Long deleteMemo(@PathVariable Long id){
        if(memoList.containsKey(id)){
            memoList.remove(id);
            return id;
        }
        else{
            throw new IllegalArgumentException("선택한 메모가 존재하지 않습니다.");
        }
    }
}
