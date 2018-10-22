package com.jy.service;

import com.jy.model.User;

/**
 * Created by Administrator on 2018/10/20.
 */
public interface UserService {
    User getUserByNameAndPass(User user);
    boolean addUser(User user);
}
