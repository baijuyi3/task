package com.jy.service;

import com.jy.model.Deliver;
import com.jy.model.Department;
import com.jy.model.Position;
import com.jy.model.Recruit;

import java.util.List;

/**
 * Created by Administrator on 2018/10/24.
 */
public interface AdminService {
    //    *********面试流程**********
    boolean updateDeliver(Deliver deliver);
    List<Deliver> getDeliverByState(int state);
    Deliver getDeliverById(int id);
    //    *********招聘信息**********
    boolean saveRecruit(Recruit recruit);
    boolean delRecruit(int id);
    boolean updateRecruit(Recruit recruit);
    List<Recruit> getRecruits();
    Recruit getRecruitById(int id);
    //    *********部门*********
    boolean saveDepartment(Department department);
    boolean delDepartment(int id);
    boolean updateDepartment(Department department);
    List<Department> getAllDepartment();
    Department getDepartmentById(int id);
    //    *********职位**********
    boolean savePosition(Position position);
    boolean delPosition(int id);
    boolean updatePosition(Position position);
    List<Position> getAllPosition();
    Position getPositionById(int id);
}
