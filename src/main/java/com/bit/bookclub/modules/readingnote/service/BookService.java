package com.bit.bookclub.modules.readingnote.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit.bookclub.modules.readingnote.entity.Book;
import com.bit.bookclub.modules.readingnote.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	// 리스트 처리
	public List<Book> getBookList() {
		
		return bookRepository.findAll();
	}
	
	// id 조회 처리
	public Optional<Book> getBookListById(Integer id) {
		
		return bookRepository.findById(id);
	}
	
	// 작성 처리
	public Book registBook(Book book) {
		
		return bookRepository.save(book);
	}
	
	// 수정 처리
	public Book updateBook(Book book) {
		
		return bookRepository.saveAndFlush(book);
	}
	
	// 삭제 처리
	public void removeBook(Integer id) {
		
		bookRepository.deleteById(id);
	}
	
}
