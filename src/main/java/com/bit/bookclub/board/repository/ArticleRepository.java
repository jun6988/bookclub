package com.bit.bookclub.board.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.bit.bookclub.board.domain.Article;
import com.bit.bookclub.board.repository.querydsl.ArticleRepositoryCustom;
import com.bitacademy.projectboard.domain.QArticle;
import com.querydsl.core.types.dsl.DateTimeExpression;
import com.querydsl.core.types.dsl.StringExpression;

@RepositoryRestResource // DataRestRepository라는 것을 명시. 
public interface ArticleRepository extends
        JpaRepository<Article, Long>, 
        ArticleRepositoryCustom,
        QuerydslPredicateExecutor<Article>, // Article 안에 모든 검색기능 활성화 
        QuerydslBinderCustomizer<QArticle> {

    Page<Article> findByTitleContaining(String title, Pageable pageable);
    Page<Article> findByContentContaining(String content, Pageable pageable);
    Page<Article> findByUserAccount_UserIdContaining(String userId, Pageable pageable);
    Page<Article> findByUserAccount_NicknameContaining(String nickname, Pageable pageable);
    Page<Article> findByHashtag(String hashtag, Pageable pageable);

    void deleteByIdAndUserAccount_UserId(Long articleId, String userid);

    @Override
    default void customize(QuerydslBindings bindings, QArticle root) {
        bindings.excludeUnlistedProperties(true); // Articles에서 원하는 검색기능만 사용하기 위해 설정 후 밑에 root로 설정해줌 
        bindings.including(root.title, root.content, root.hashtag, root.createdAt, root.createdBy);
        // 대소문자 구분 안하는 검색기능 
        bindings.bind(root.title).first(StringExpression::containsIgnoreCase);
        bindings.bind(root.content).first(StringExpression::containsIgnoreCase);
        bindings.bind(root.hashtag).first(StringExpression::containsIgnoreCase);
        bindings.bind(root.createdAt).first(DateTimeExpression::eq);
        bindings.bind(root.createdBy).first(StringExpression::containsIgnoreCase);
    }

}