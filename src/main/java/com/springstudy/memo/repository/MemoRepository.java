package com.springstudy.memo.repository;

import com.springstudy.memo.entity.Memo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MemoRepository extends JpaRepository<Memo, Long> {



}
