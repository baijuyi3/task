package com.jy.dao;

import com.jy.model.Recruit;

import java.util.List;

/**
 * Created by Administrator on 2018/10/23.
 */
public interface RecruitDao {
    int saveRecruit(Recruit recruit);
    int delRecruit(int id);
    int updateRecruit(Recruit recruit);
    List<Recruit> getRecruits();
    Recruit getRecruitById(int id);
}
