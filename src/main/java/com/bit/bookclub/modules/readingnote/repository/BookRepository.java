package com.bit.bookclub.modules.readingnote.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bit.bookclub.modules.readingnote.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{

}
