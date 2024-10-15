package com.springstudy.memo.dto;

import com.springstudy.memo.entity.MemoEntity;
import lombok.Getter;

@Getter
public class MemoResponseDto {
    private Long id;
    private String username;
    private String contents;

    public MemoResponseDto(MemoEntity memo) {
        this.id = memo.getId();
        this.username = memo.getUsername();
        this.contents = memo.getContents();
    }
}