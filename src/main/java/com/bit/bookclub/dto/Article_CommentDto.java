package com.bit.bookclub.dto;

import java.time.LocalDateTime;

import com.bit.bookclub.domain.Article;
import com.bit.bookclub.domain.Article_Comment;
import com.bit.bookclub.modules.account.domain.entity.Account;




public record Article_CommentDto(
        Long id,
        Long articleId,
        AccountDto accountDto,
        String content,
        LocalDateTime createdAt,
        String createdBy,
        LocalDateTime modifiedAt,
        String modifiedBy
) {

    public static Article_CommentDto of(Long articleId, AccountDto accountDto, String content) {
        return new Article_CommentDto(null, articleId, accountDto, content, null, null, null, null);
    }
    public static Article_CommentDto of(Long id, Long articleId, AccountDto accountDto, String content, LocalDateTime createdAt, String createdBy, LocalDateTime modifiedAt, String modifiedBy) {
        return new Article_CommentDto(id, articleId, accountDto, content, createdAt, createdBy, modifiedAt, modifiedBy);
    }

    public static Article_CommentDto from(Article_Comment entity) {
        return new Article_CommentDto(
                entity.getId(),
                entity.getArticle().getId(),
                AccountDto.from(entity.getAccount()),
                entity.getContent(),
                entity.getCreatedAt(),
                entity.getCreatedBy(),
                entity.getModifiedAt(),
                entity.getModifiedBy()
        );
    }

    public Article_Comment toEntity(Article article, Account account) {
        return Article_Comment.of(
                article,
                account,
                content
        );
    }

}