package com.bit.bookclub.dto.Response;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.bit.bookclub.dto.ArticleWithCommentsDto;

public record ArticleWithCommentsResponse(
        Long id,
        String title,
        String content,
        String hashtag,
        LocalDateTime createdAt,
        String email,
        String nickname,
        Set<Article_CommentResponse> article_CommentsResponse
) {

    public static ArticleWithCommentsResponse of(Long id, String title, String content, String hashtag, LocalDateTime createdAt, String email, String nickname, Set<Article_CommentResponse> article_CommentResponses) {
        return new ArticleWithCommentsResponse(id, title, content, hashtag, createdAt, email, nickname, article_CommentResponses);
    }

    public static ArticleWithCommentsResponse from(ArticleWithCommentsDto dto) {
        String nickname = dto.accountDto().nickname();
        

        return new ArticleWithCommentsResponse(
                dto.id(),
                dto.title(),
                dto.content(),
                dto.hashtag(),
                dto.createdAt(),
                dto.accountDto().email(),
                dto.accountDto().nickname(),
                dto.article_CommentDtos().stream()
                        .map(Article_CommentResponse::from)
                        .collect(Collectors.toCollection(LinkedHashSet::new))
        );
    }

}