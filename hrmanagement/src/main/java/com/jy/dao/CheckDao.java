package com.jy.dao;

import com.jy.model.Check;

import java.util.List;

/**
 * Created by Administrator on 2018/11/1.
 */
public interface CheckDao {
    int saveCheck(Check check);
    int updateCheck(Check check);
    List<Check> getCheckByState(int state);
    Check getCheckById(int id);
}
