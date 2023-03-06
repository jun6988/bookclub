package com.bit.bookclub.modules.readingnote.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bit.bookclub.modules.readingnote.entity.ReadingNoteComment;

public interface ReadingNoteCommentRepository extends JpaRepository<ReadingNoteComment, Integer>{

}
