package com.jy.service;

import com.jy.model.*;

import java.util.List;

/**
 * Created by Administrator on 2018/10/20.
 */
public interface EmployeeService {
    boolean saveAttend(int eid);
    boolean updateAttend(Attend attend);
    Attend getAttendsByEidAndDD(int eid,String yyyymmdd);
}
