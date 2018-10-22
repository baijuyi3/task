package com.jy.dao;

import com.jy.model.User;
import org.apache.ibatis.annotations.Mapper;


/**
 * Created by Administrator on 2018/10/20.
 */
public interface UserDao  {
    User getUserByNameAndPass(User user);
    int addUser(User user);
}
