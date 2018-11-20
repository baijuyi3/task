package com.jy.dao;

import com.jy.model.Attend;

import java.util.List;

/**
 * Created by Administrator on 2018/10/31.
 */
public interface AttendDao {
    int saveAttend(int eid);
    int updateAttend(Attend attend);
    List<Attend> getAttendsByEidAndMM(int eid,String yyyymm);
    Attend getAttendsByEidAndDD(int eid,String yyyymmdd);
}
