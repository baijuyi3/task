package com.jy.service;

import com.jy.model.Deliver;

import java.util.List;

/**
 * Created by Administrator on 2018/10/24.
 */
public interface AdminService {
    boolean updateDeliver(Deliver deliver);
    List<Deliver> getDeliverByState(int state);
    Deliver getDeliverById(int id);
}
