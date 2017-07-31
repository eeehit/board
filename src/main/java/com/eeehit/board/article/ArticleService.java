package com.eeehit.board.article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sppark on 2017-05-21.
 */
@Service
public class ArticleService {
	@Autowired
	ArticleRepository articleRepository;

	public Article getArticleById(long id) {
		return this.articleRepository.findById(id);
	}

	public List<Article> getArticleList() {
		return this.articleRepository.findAll();
	}
}