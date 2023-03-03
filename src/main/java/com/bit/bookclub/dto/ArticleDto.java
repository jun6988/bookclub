 package com.bit.bookclub.dto;

import java.time.LocalDateTime;

import com.bit.bookclub.domain.Article;
import com.bit.bookclub.modules.account.domain.entity.Account;



// DTO 안에 넣어서 service에서 사용 
// -> Article은 DTO의 정보를 몰라도 된다는 이점  
// Article이 변경되면 DTO에 영향을 주지만 DTO가 변경되도 Article에는 영향을 주지 않는다.   
// Lombok record는 자동으로 getter setter를 생성해준다. 
public record ArticleDto(
		// entity의 모든 정보를 가지고 있다. 
        Long id,
        AccountDto accountDto,
        String title,
        String content,
        String hashtag,
        LocalDateTime createdAt,
        String createdBy,
        LocalDateTime modifiedAt,
        String modifiedBy
) {

    public static ArticleDto of(AccountDto accountDto, String title, String content, String hashtag) {
        return new ArticleDto(null, accountDto, title, content, hashtag, null, null, null, null);
    }

    public static ArticleDto of(Long id, AccountDto accountDto, String title, String content, String hashtag, LocalDateTime createdAt, String createdBy, LocalDateTime modifiedAt, String modifiedBy) {
        return new ArticleDto(id, accountDto, title, content, hashtag, createdAt, createdBy, modifiedAt, modifiedBy);
    }

    // 자기 자신을 entity로 부터 반환한다. 
    // entity를 입력하면 DTO로 변환해준다. 
    // mapping 해서 return 해줌 
    public static ArticleDto from(Article entity) {
        return new ArticleDto(
                entity.getId(),
                AccountDto.from(entity.getAccount()),
                entity.getTitle(),
                entity.getContent(),
                entity.getHashtag(),
                entity.getCreatedAt(),
                entity.getCreatedBy(),
                entity.getModifiedAt(),
                entity.getModifiedBy()
        );
    }

    // DTO로 부터 entity를 생성해주는 코드 (위 코드와 반대) 
    public Article toEntity(Account account) {
        return Article.of(
                account,
                title,
                content,
                hashtag
        );
    }

}