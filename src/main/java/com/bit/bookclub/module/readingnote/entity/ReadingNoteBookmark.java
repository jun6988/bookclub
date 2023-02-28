package com.bit.bookclub.module.readingnote.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class ReadingNoteBookmark {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer no;
	
//	User(1) : ReadingNoteBookmark(N) 설정
//	@ManyToOne
	@Column(name = "user_no")
	private Integer user_no;
	
//	ReadingNote(1) : ReadingNoteBookmark(N) 설정
//	@ManyToOne
	@Column(name = "reading_note_no")
	private Integer reading_note_no;
	
}
