package com.springstudy.memo.entity;

import com.springstudy.memo.dto.MemoRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class MemoEntity {
    private Long id;
    private String username;
    private String contents;

    public MemoEntity(MemoRequestDto requestDto) {

        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
    }
}