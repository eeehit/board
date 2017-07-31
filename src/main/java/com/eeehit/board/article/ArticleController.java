package com.eeehit.board.article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
	@Secured({"ROLE_GUEST", "ROLE_ADMIN"})
	public ModelAndView getArticleById(@PathVariable(value = "id", required = true) long id) {
		Article article = articleService.getArticleById(id);
		ModelAndView mv = new ModelAndView("article");
		mv.addObject("article", article);
		return mv;
	}

	@RequestMapping(value = "{id}/modify", method = RequestMethod.GET)
	@ResponseBody
	@Secured({"ROLE_ADMIN"})
	public ModelAndView getArticleById2(@PathVariable(value = "id", required = true) long id) {
		Article article = articleService.getArticleById(id);
		ModelAndView mv = new ModelAndView("article");
		mv.addObject("article", article);
		return mv;
	}
}