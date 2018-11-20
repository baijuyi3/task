package com.jy.dao;

import com.jy.model.Reward;

import java.util.List;

/**
 * Created by Administrator on 2018/10/31.
 */
public interface RewardDao {
    int saveReward(Reward reward);
    int updateReward(Reward reward);
    List<Reward> getAllReward();
    List<Reward> getRewardByEid(int eid);
    List<Reward> getRewardByEidAndTime(int eid,String time);
    Reward getRewardById(int id);
}
