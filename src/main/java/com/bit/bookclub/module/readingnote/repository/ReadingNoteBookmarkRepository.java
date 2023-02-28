package com.bit.bookclub.module.readingnote.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bit.bookclub.module.readingnote.entity.ReadingNoteBookmark;

public interface ReadingNoteBookmarkRepository extends JpaRepository<ReadingNoteBookmark, Integer>{

}