package com.bit.bookclub.module.readingnote.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bit.bookclub.module.readingnote.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{

}
