package com.bit.bookclub.module.readingnote.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bit.bookclub.module.readingnote.entity.ReadingNoteComment;

public interface ReadingNoteCommentRepository extends JpaRepository<ReadingNoteComment, Integer>{

}
