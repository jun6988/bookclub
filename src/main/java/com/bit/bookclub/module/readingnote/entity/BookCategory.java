package com.bit.bookclub.module.readingnote.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class BookCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer no;
	
	private String book_category_name;
	
////	User(1) : BookCategory(N) 설정
////	@ManyToOne
//	@Column(name = "user_no")
//	private Integer user_no;
	
//	BookCategory(1) : Book(N) 설정
	@OneToMany(mappedBy = "book_category_no")
	public List<Book> book;
}
