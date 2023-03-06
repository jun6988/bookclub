package com.bit.bookclub.modules.readingnote.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bit.bookclub.modules.readingnote.entity.ReadingNote;

public interface ReadingNoteRepository extends JpaRepository<ReadingNote, Integer>{

}
