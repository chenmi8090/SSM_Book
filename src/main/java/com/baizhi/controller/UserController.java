package com.baizhi.controller;

import com.baizhi.entity.Result;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/loginUser")
    //登陆
    public String loginUser(User user, HttpServletRequest request) {
        User loginUser = userService.selectByUsernameAndPassword(user);
        if (loginUser != null) {
            request.getSession().setAttribute("user",loginUser);
            return "redirect:/books/showAllBooks";
        } else {
            return "redirect:/users/login.jsp";
        }
    }

    @RequestMapping("/insertUser")
    //注册
    public String insertUser(User user, String code) {

        Jedis jedis = new Jedis("192.168.197.137", 7000);
        String randomCode = jedis.get("code");
        if (randomCode.equals(code)) {
            userService.insertUser(user);
            return "redirect:/users/login.jsp";
        } else {
            return "redirect:/users/regist.jsp";
        }
    }

    @RequestMapping("/send")
    @ResponseBody
    //获得验证码
    public Result send(String phone) {

        //获取验证码得到返回值对象
        Result result = userService.getCode(phone);

        return result;
    }
}
