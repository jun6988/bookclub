package com.bit.bookclub.modules.readingnote.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bit.bookclub.modules.readingnote.entity.BookCategory;

public interface BookCategoryRepository extends JpaRepository<BookCategory, Integer>{

}
