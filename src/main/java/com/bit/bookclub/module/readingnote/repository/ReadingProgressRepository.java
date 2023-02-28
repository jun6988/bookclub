package com.bit.bookclub.module.readingnote.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bit.bookclub.module.readingnote.entity.ReadingProgress;

public interface ReadingProgressRepository extends JpaRepository<ReadingProgress, Integer> {

}
