package com.bit.bookclub.board.dto.Response;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.bit.bookclub.board.dto.ArticleWithCommentsDto;
import com.bit.bookclub.board.dto.Article_CommentDto;

public record ArticleWithCommentsResponse(
        Long id,
        String title,
        String content,
        String hashtag,
        LocalDateTime createdAt,
        String email,
        String nickname,
        String userId,
        Set<Article_CommentResponse> article_CommentsResponse
) {

    public static ArticleWithCommentsResponse of(Long id, String title, String content, String hashtag, LocalDateTime createdAt, String email, String nickname, String userId, Set<Article_CommentResponse> article_CommentResponses) {
        return new ArticleWithCommentsResponse(id, title, content, hashtag, createdAt, email, nickname, userId, article_CommentResponses);
    }

    public static ArticleWithCommentsResponse from(ArticleWithCommentsDto dto) {
        String nickname = dto.userAccountDto().nickname();
        if (nickname == null || nickname.isBlank()) {
            nickname = dto.userAccountDto().userId();
        }

        return new ArticleWithCommentsResponse(
                dto.id(),
                dto.title(),
                dto.content(),
                dto.hashtag(),
                dto.createdAt(),
                dto.userAccountDto().email(),
                nickname,
                dto.userAccountDto().userId(),
                dto.article_CommentDtos().stream()
                        .map(Article_CommentResponse::from)
                        .collect(Collectors.toCollection(LinkedHashSet::new))
        );
    }

}