package com.baizhi.service;

import com.baizhi.entity.Result;
import com.baizhi.entity.User;

import java.util.List;

public interface UserService {

    public User selectByUsernameAndPassword(User user);

    public void insertUser(User user);

    public Result getCode(String phone);

}
