package com.bit.bookclub.module.readingnote.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bit.bookclub.module.readingnote.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	Integer countByGender(String gender);
	
}
