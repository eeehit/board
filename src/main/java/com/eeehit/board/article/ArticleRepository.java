package com.eeehit.board.article;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by trinity on 17. 5. 17.
 */
public interface ArticleRepository extends CrudRepository<Article, Long> {
	Article findById(long id);
}