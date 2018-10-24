package com.jy.service.impl;

import com.jy.dao.DeliverDao;
import com.jy.dao.RecruitDao;
import com.jy.model.Deliver;
import com.jy.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/10/24.
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private RecruitDao recruitDao;
    @Autowired
    private DeliverDao deliverDao;
//    ****************************面试申请**********************
    @Override
    public boolean updateDeliver(Deliver deliver) {
        return false;
    }

    @Override
    public List<Deliver> getDeliverByState(int state) {
        return null;
    }

    @Override
    public Deliver getDeliverById(int id) {
        return deliverDao.getDeliverById(id);
    }
}
