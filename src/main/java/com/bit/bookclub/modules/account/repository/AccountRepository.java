package com.bit.bookclub.modules.account.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.transaction.annotation.Transactional;

import com.bit.bookclub.modules.account.domain.entity.Account;

@Transactional(readOnly = true)
public interface AccountRepository extends JpaRepository<Account, Long>,
    QuerydslPredicateExecutor<Account> {

  boolean existsByEmail(String email);

  boolean existsByNickname(String nickname);

  Account findByEmail(String email);

  Account findByNickname(String nickname);

  @EntityGraph(attributePaths = {"tags", "zones"})
  Account findAccountWithTagsAndZonesById(Long id);
}
