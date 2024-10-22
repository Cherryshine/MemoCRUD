package com.springstudy.memo.controller;

import com.springstudy.memo.dto.MemoRequestDto;
import com.springstudy.memo.dto.MemoResponseDto;
import com.springstudy.memo.service.MemoService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MemoController {

   // private final JdbcTemplate jdbcTemplate;
    private final MemoService memoService;
    public MemoController(JdbcTemplate jdbcTemplate) {
       this.memoService = new MemoService(jdbcTemplate);
        // this.jdbcTemplate = jdbcTemplate;
    }

    @PostMapping("/memos")
    public MemoResponseDto createMemo(@RequestBody MemoRequestDto requestDto) {

        return memoService.createMemo(requestDto);
    }

    @GetMapping("/memos")
    public List<MemoResponseDto> getMemos() {

        return memoService.getMemos();
    }

    @PutMapping("/memos/{id}")
    public Long updateMemo(@PathVariable Long id, @RequestBody MemoRequestDto requestDto) {

        return memoService.updateMemo(id, requestDto);
    }

    @DeleteMapping("/memos/{id}")
    public Long deleteMemo(@PathVariable Long id) {

        return memoService.deleteMemo(id);
    }
}