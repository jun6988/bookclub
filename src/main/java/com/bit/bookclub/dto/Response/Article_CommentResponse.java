package com.bit.bookclub.dto.Response;

import java.time.LocalDateTime;

import com.bit.bookclub.dto.Article_CommentDto;

// 댓글 요청하는 controller에 응답하는 DTO (Controller에서만 사용) 
// -> controller에서는 response dto오를 최소화 / 일반 dto 존재 모르고 request, response dto만 알 수 있다.
// dto, domain 존재를 모두 알고 있는 곳 = Service
public record Article_CommentResponse(
        Long id,
        String content,
        LocalDateTime createdAt,
        String email,
        String nickname
) {

    public static Article_CommentResponse of(Long id, String content, LocalDateTime createdAt, String email, String nickname) {
        return new Article_CommentResponse(id, content, createdAt, email, nickname);
    }

    // nickname 가공 
    // user account에서 꺼내는 장면 
    public static Article_CommentResponse from(Article_CommentDto dto) { // Article_CommentDto를 받아서   
    	String nickname = dto.accountDto().nickname();

        return new Article_CommentResponse(
                dto.id(),
                dto.content(),
                dto.createdAt(),
                dto.accountDto().email(),
                dto.accountDto().nickname()
        );
    }

}
