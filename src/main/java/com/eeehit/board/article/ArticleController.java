package com.eeehit.board.article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * Created by sppark on 2017-05-21.
 */
@Controller
@RequestMapping("article")
public class ArticleController {
	@Autowired
	ArticleService articleService;

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView getArticleById(@PathVariable(value = "id", required = true) long id) {
		Article article = articleService.getArticleById(id);
		ModelAndView mv = new ModelAndView("article");
		mv.addObject("article", article);
		return mv;
	}

	@RequestMapping(value = "{id}/modify", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView getArticleById2(
			@PathVariable(value = "id", required = true) long id,
			HttpSession httpSession) {
		Article article = articleService.getArticleById(id);
		String realAuthor = article.getAuthor();
		String currentUser = (String) httpSession.getAttribute("username");
		if (realAuthor.equals(currentUser)) {
			ModelAndView mv = new ModelAndView("article");
			mv.addObject("article", article);
			return mv;
		}
		return new ModelAndView("error/403");
	}
}