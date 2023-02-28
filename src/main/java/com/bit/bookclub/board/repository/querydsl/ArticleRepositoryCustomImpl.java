package com.bit.bookclub.board.repository.querydsl;

import java.util.List;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import com.bit.bookclub.board.domain.Article;
import com.bitacademy.projectboard.domain.QArticle;
import com.querydsl.jpa.JPQLQuery;

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
