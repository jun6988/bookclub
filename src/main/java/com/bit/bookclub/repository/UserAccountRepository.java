package com.bit.bookclub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bit.bookclub.domain.UserAccount;

public interface UserAccountRepository extends JpaRepository<UserAccount, String> {
}
