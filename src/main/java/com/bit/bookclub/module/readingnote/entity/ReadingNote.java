package com.bit.bookclub.module.readingnote.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class ReadingNote {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer no;
	
	private String reading_note_title;
	
	private String reading_note_hashtag;
	
	private String reading_note_content;
	
	private Integer reading_note_hit;
	
	private Integer reading_note_like;
	
	private Integer reading_note_bookmark;
	
	private LocalDateTime reading_note_regdate;
	
	private String reading_note_file_url;
	
	private Integer reading_note_open;
	
////	User(1) : ReadingNote(N) 설정
////	@ManyToOne
//	@Column(name = "user_no")
//	private Integer user_no;
	
//	Book(1) : ReadingNote(N) 설정
//	@ManyToOne
	@Column(name = "book_no")
	private Integer book_no;
	
//	ReadingNote(1) : ReadingNoteBookmark(N) 설정
	@OneToMany(mappedBy = "reading_note_no")
	public List<ReadingNoteBookmark> readingNoteBookmark;
	
//	ReadingNote(1) : ReadingNoteComment(N) 설정
	@OneToMany(mappedBy = "reading_note_no")
	public List<ReadingNoteComment> readingNoteComment;
	
////	ReadingNote(1) : Heart(N) 설정
//	@OneToMany(mappedBy = "reading_note_no")
//	public List<Heart> heart;
	
}
