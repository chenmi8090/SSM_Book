package com.baizhi.service;

import com.baizhi.dao.UserDAO;
import com.baizhi.entity.Result;
import com.baizhi.entity.User;
import com.baizhi.util.RandomCode;
import com.baizhi.util.Send;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import redis.clients.jedis.Jedis;

import java.util.UUID;

@Service
public class UserServiceImplements implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    @Transactional(propagation= Propagation.SUPPORTS)
    public User selectByUsernameAndPassword(User user) {
        return userDAO.selectByUsernameAndPassword(user);
    }

    @Override
    @Transactional
    public void insertUser(User user) {
        user.setId(UUID.randomUUID().toString());
        userDAO.insert(user);
    }

    @Override
    public Result getCode(String phone) {

        //获取验证码并且发送消息到手机号中
        String randomCode = RandomCode.getCode(4);
        String send = Send.getSend(phone, randomCode);

        //判断是否成功发送消息
        Jedis jedis = new Jedis("192.168.197.137",7000);
        Result result = new Result();
        if((send.trim()).equals("100")){
            jedis.setex("code",60,randomCode);
            result.setStatus(true);
            result.setMessage("验证码发送成功,请注意查收!");
            return result;
        }else{
            result.setStatus(false);
            result.setMessage("验证码发送失败,请60秒后重新点击发送!");
            return result;
        }
    }


}
