package com.jy.service.impl;

import com.jy.dao.*;
import com.jy.model.*;
import com.jy.service.EmployeeService;
import com.jy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/10/20.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private AttendDao attendDao;

    @Override
    public boolean saveAttend(int eid) {
        int row=attendDao.saveAttend(eid);
        return true;
    }

    @Override
    public boolean updateAttend(Attend attend) {
        int row=attendDao.updateAttend(attend);
        return true;
    }



    @Override
    public Attend getAttendsByEidAndDD(int eid, String yyyymmdd) {
        return attendDao.getAttendsByEidAndDD(eid, yyyymmdd);
    }
}
