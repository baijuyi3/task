package com.jy.dao;

import com.jy.model.Deliver;

import java.util.List;

/**
 * Created by Administrator on 2018/10/24.
 */
public interface DeliverDao {
    int saveDeliver(Deliver deliver);
    int delDeliver(int id);
    int updateDeliver(Deliver deliver);
    List<Deliver> getDeliverByState(int state);
    List<Deliver> getDeliverByUid(int u_id);
    List<Deliver> getDeliverByUidAndState(int u_id,int state);
    Deliver getDeliverByUidAndRcid(int u_id,int rc_id);
}
