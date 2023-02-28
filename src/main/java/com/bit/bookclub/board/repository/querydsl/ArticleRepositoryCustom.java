package com.bit.bookclub.board.repository.querydsl;

import java.util.List;

public interface ArticleRepositoryCustom {
	List<String> findAllDistinctHashtags();

}
