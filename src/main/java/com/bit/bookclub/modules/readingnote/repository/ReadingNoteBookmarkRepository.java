package com.bit.bookclub.modules.readingnote.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bit.bookclub.modules.readingnote.entity.ReadingNoteBookmark;

public interface ReadingNoteBookmarkRepository extends JpaRepository<ReadingNoteBookmark, Integer>{

}
