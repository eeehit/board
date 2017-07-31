package com.eeehit.board.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * Created by sppark on 2017-07-31.
 */
@Controller
@RequestMapping("myPage")
public class MyPageController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView myPage(HttpSession httpSession){
        ModelAndView mv = new ModelAndView("myPage");
        String username = (String) httpSession.getAttribute("username");
        User user = (User) userService.loadUserByUsername(username);
        mv.addObject("user", user);
        mv.addObject("roles", user.getAuthority());
        return mv;
    }
}
