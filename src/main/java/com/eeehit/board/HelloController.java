package com.eeehit.board;

import com.eeehit.board.article.Article;
import com.eeehit.board.article.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class HelloController {
	@Autowired
	ArticleService articleService;

	@RequestMapping("/")
	public ModelAndView index() {
		List<Article> articleList = articleService.getArticleList();
		ModelAndView mv = new ModelAndView("main");
		mv.addObject("articleList", articleList);
		return mv;
	}
}
