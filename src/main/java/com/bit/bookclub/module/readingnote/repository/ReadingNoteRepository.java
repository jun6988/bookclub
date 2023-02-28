package com.bit.bookclub.module.readingnote.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bit.bookclub.module.readingnote.entity.ReadingNote;

public interface ReadingNoteRepository extends JpaRepository<ReadingNote, Integer>{

}