package com.bit.bookclub.module.readingnote.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class ReadingNoteComment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer no;
	
	private String user_id;
	
	private String content;
	
	private Integer reading_note_comment_like;
	
	private LocalDateTime reading_note_comment_regdate;
	
//	ReadingNote(1) : ReadingNoteComment(N) 설정
//	@ManyToOne
	@Column(name = "reading_note_no")
	private Integer reading_note_no;
	
}