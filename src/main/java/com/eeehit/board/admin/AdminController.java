package com.eeehit.board.admin;

import com.eeehit.board.user.User;
import com.eeehit.board.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by sppark on 2017-07-31.
 */
@RestController
@RequestMapping("admin")
@Secured("ROLE_ADMIN")
public class AdminController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "userList", method = RequestMethod.GET)
    public List<User> getUserList() {
        return this.userService.getUserList();
    }
}
