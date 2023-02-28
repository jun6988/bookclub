package com.bit.bookclub.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bit.bookclub.board.domain.UserAccount;

public interface UserAccountRepository extends JpaRepository<UserAccount, String> {
}
