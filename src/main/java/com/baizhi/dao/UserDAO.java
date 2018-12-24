package com.baizhi.dao;

import com.baizhi.entity.User;

public interface UserDAO extends UtilDAO<User> {

    public User selectByUsernameAndPassword(User user);

}
