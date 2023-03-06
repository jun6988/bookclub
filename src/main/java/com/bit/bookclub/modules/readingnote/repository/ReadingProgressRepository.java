package com.bit.bookclub.modules.readingnote.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bit.bookclub.modules.readingnote.entity.ReadingProgress;

public interface ReadingProgressRepository extends JpaRepository<ReadingProgress, Integer> {

}
