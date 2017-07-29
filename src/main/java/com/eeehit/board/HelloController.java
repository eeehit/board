package com.eeehit.board;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@RestController
public class HelloController {
	@RequestMapping("/")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("main");
		return mv;
	}
}
