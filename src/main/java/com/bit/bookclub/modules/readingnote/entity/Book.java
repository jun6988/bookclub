package com.bit.bookclub.modules.readingnote.entity;

import java.util.List;

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
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String book_title;
	
	private String book_ISBN;
	
	private String book_author;
	
	private String book_publisher;
	
	private String book_img_url;
	
//	BookCategory(1) : Book(N) 설정
//	@ManyToOne
	@Column(name = "book_category_id")
	private Integer book_category_id;
	
//	Book(1) : ReadingNote(N) 설정
	@OneToMany(mappedBy = "book_id", fetch = FetchType.EAGER)
	public List<ReadingNote> readingNote;
	
}
