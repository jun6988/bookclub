package com.bit.bookclub.repository.querydsl;

import java.util.List;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import com.bit.bookclub.domain.Article;
import com.bit.bookclub.domain.QArticle;

public class ArticleRepositoryCustomImpl extends QuerydslRepositorySupport implements ArticleRepositoryCustom {
	
	public ArticleRepositoryCustomImpl() {
		super(Article.class);
	}

	@Override
	public List<String> findAllDistinctHashtags() {
		QArticle article = QArticle.article;
		
		return from(article)
				.distinct()
				.select(article.hashtag)
				.where(article.hashtag.isNotNull())
				.fetch();

	}
}
