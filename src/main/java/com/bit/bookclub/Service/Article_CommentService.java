package com.bit.bookclub.Service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bit.bookclub.domain.Article;
import com.bit.bookclub.domain.Article_Comment;
import com.bit.bookclub.domain.UserAccount;
import com.bit.bookclub.dto.Article_CommentDto;
import com.bit.bookclub.repository.ArticleRepository;
import com.bit.bookclub.repository.Article_CommentRepository;
import com.bit.bookclub.repository.UserAccountRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class Article_CommentService {

    private final ArticleRepository articleRepository;
    private final Article_CommentRepository article_CommentRepository;
    private final UserAccountRepository userAccountRepository;

    @Transactional(readOnly = true)
    public List<Article_CommentDto> searchArticle_Comments(Long articleId) {
        return article_CommentRepository.findByArticle_Id(articleId)
                .stream()
                .map(Article_CommentDto::from)
                .toList();
    }

    public void saveArticle_Comment(Article_CommentDto dto) {
        try {
            Article article = articleRepository.getReferenceById(dto.articleId());
            UserAccount userAccount = userAccountRepository.getReferenceById(dto.userAccountDto().userId());
            article_CommentRepository.save(dto.toEntity(article, userAccount));
        } catch (EntityNotFoundException e) {
            log.warn("댓글 저장 실패. 댓글 작성에 필요한 정보를 찾을 수 없습니다 - {}", e.getLocalizedMessage());
        }
    }

    public void updateArticle_Comment(Article_CommentDto dto) {
        try {
            Article_Comment articleComment = article_CommentRepository.getReferenceById(dto.id());
            if (dto.content() != null) { articleComment.setContent(dto.content()); }
        } catch (EntityNotFoundException e) {
            log.warn("댓글 업데이트 실패. 댓글을 찾을 수 없습니다 - dto: {}", dto);
        }
    }

    public void deleteArticle_Comment(Long article_CommentId, String userId) {
        article_CommentRepository.deleteByIdAndUserAccount_UserId(article_CommentId, userId);
    }

}
