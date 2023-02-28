package com.bit.bookclub.dto.request;

import com.bit.bookclub.dto.Article_CommentDto;
import com.bit.bookclub.dto.UserAccountDto;

public record Article_CommentRequest(Long articleId, String content) {

    public static Article_CommentRequest of(Long articleId, String content) {
        return new Article_CommentRequest(articleId, content);
    }

    public Article_CommentDto toDto(UserAccountDto userAccountDto) {
        return Article_CommentDto.of(
                articleId,
                userAccountDto,
                content
        );
    }

}