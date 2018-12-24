package com.baizhi.test;

import com.baizhi.entity.Result;
import com.baizhi.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class UserTest {

    @Autowired
    private UserService userService;

    @Test
    public void showAllUser(){
        Result code = userService.getCode("12345678912");
        System.out.println(code);
    }

    @Test
    public void userLoginTest(){
        System.out.println("登陆");
    }

}
