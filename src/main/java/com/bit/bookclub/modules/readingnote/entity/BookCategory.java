package com.bit.bookclub.modules.readingnote.entity;

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
	private Integer id;
	
	private String book_category_name;
	
//	BookCategory(1) : Book(N) 설정
	@OneToMany(mappedBy = "book_category_id")
	public List<Book> book;
	
}
