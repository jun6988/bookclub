package com.bit.bookclub.modules.readingnote.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	private Integer id;
	
	private String reading_note_title;
	
	private String reading_note_hashtag;
	
	private String reading_note_content;
	
	private Integer reading_note_hit;
	
	private Integer reading_note_like;
	
	private Integer reading_note_bookmark;
	
	private String reading_note_regdate;
	
	private String reading_note_file_url;
	
	private Integer reading_note_open;
	
////	Account(1) : ReadingNote(N) 설정
////	@ManyToOne
//	@Column(name = "account_id")
//	private Integer account_id;
	
//	Book(1) : ReadingNote(N) 설정
//	@ManyToOne
	@Column(name = "book_id")
	private Integer book_id;
	
//	ReadingNote(1) : ReadingNoteBookmark(N) 설정
	@OneToMany(mappedBy = "reading_note_id", fetch = FetchType.EAGER)
	public Set<ReadingNoteBookmark> readingNoteBookmark;
	
//	ReadingNote(1) : ReadingNoteComment(N) 설정
	@OneToMany(mappedBy = "reading_note_id", fetch = FetchType.EAGER)
	public Set<ReadingNoteComment> readingNoteComment;
	
}
