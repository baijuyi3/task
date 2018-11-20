package com.jy.service;

import com.jy.model.*;

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
    Department getDepartmentByName(String name);
    //    *********职位**********
    boolean savePosition(Position position);
    boolean delPosition(int id);
    boolean updatePosition(Position position);
    List<Position> getAllPosition();
    Position getPositionById(int id);
    Position getPositionByName(String name);
    //    *********员工**********
    boolean saveEmployee(Employee employee);
    boolean delEmployee(int id);
    boolean updateEmployee(Employee employee);
    List<Employee> getAllEmployee();
    List<Employee> getEmployeeByDid(int did);
    Employee getEmployeeById(int id);
    Employee getEmployeeByUser(String user);
    Employee getEmployeeByUid(int uid);
    //    *********培训**********
    boolean saveTrain(Train train);
    boolean delTrain(int id);
    boolean updateTrain(Train train);
    List<Train> getAllTrain();
    Train getTrainById(int id);
    //    *********培训记录**********
    boolean saveTrainRecord(TrainRecord trainRecord);
    boolean delTrainRecord(int id);
    boolean updateTrainRecord(TrainRecord trainRecord);
    List<TrainRecord> getAllTrainRecord();
    TrainRecord getTrainRecordById(int id);
    List<TrainRecord> getTrainRecordByEid(int eid);
    //    *********奖惩**********
    boolean saveReward(Reward reward);
    boolean updateReward(Reward reward);
    List<Reward> getAllReward();
    List<Reward> getRewardByEid(int eid);
    List<Reward> getRewardByEidAndTime(int eid,String time);
    Reward getRewardById(int id);
    //************复议**************
    boolean saveCheck(Check check);
    boolean updateCheck(Check check);
    List<Check> getCheckByState(int state);
    Check getCheckById(int id);
    //************薪资**************
    boolean saveSalary(Salary salary);
    List<Salary> getSalaryByEid(int eid);
    List<Salary> getSalaryByTime(String  time);
    Salary getSalaryByEidAndTime(int eid ,String time);
    List<Attend> getAttendsByEidAndMM(int eid,String yyyymm);
}
