package com.jy.service.impl;

import com.jy.dao.UserDao;
import com.jy.model.User;
import com.jy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2018/10/20.
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;
    @Override
    //    *******************用户*********************
    public User getUserByNameAndPass(User user) {
        if(user==null){
            return null;
        }
        User user1=userDao.getUserByNameAndPass(user);
        return user1;
    }

    @Override
    public boolean addUser(User user) {
        if(user==null){
            return false;
        }
        int row=userDao.addUser(user);
        if(0!=row){
            return true;
        }
        return false;
    }
}
