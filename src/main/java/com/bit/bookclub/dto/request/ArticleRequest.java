package com.bit.bookclub.dto.request;

import com.bit.bookclub.dto.AccountDto;
import com.bit.bookclub.dto.ArticleDto;

public record ArticleRequest(
        String title,
        String content,
        String hashtag
) {

    public static ArticleRequest of(String title, String content, String hashtag) {
        return new ArticleRequest(title, content, hashtag);
    }

    public ArticleDto toDto(AccountDto accountDto) {
        return ArticleDto.of(
                accountDto,
                title,
                content,
                hashtag
        );
    }

}
