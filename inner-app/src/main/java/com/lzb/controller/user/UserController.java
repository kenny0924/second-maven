package com.lzb.controller.user;

import com.lzb.common.util.UserUtil;
import com.lzb.domain.entity.User;
import com.lzb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by YJC on 2016-10-03.
 */
@Controller
public class UserController {

    public UserController () {
        System.out.print("userController");
    }

    @Autowired
    private UserService userService;



    @RequestMapping("/userLogin")
    public String loginUser(@RequestParam String username, @RequestParam String password,
                            HttpServletRequest req, HttpServletResponse resp) {

        System.out.print(username + "\t1" + password);

        try {
            User u = this.userService.getUserLogin(username, password);
            if (u != null) {
                // 用户存在
                req.getSession().setAttribute(UserUtil.USER_SESSION_KEY, u);
                return "pages/index";
            } else {
                // 用户不存在
                return "index";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "index";
        }
    }
}
