package com.jy.service.impl;

import com.jy.dao.*;
import com.jy.model.*;
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
    @Autowired
    private DepartmentDao departmentDao;
    @Autowired
    private PositionDao positionDao;
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private TrainDao trainDao;
    @Autowired
    private TrainRecordDao trainRecordDao;
    @Autowired
    private RewardDao rewardDao;
    @Autowired
    private CheckDao checkDao;
    @Autowired
    private SalaryDao salaryDao;
    @Autowired
    private AttendDao attendDao;
//    ****************************面试流程**********************
    @Override
    public boolean updateDeliver(Deliver deliver) {
        if(deliver==null){
            return false;
        }
        int row=deliverDao.updateDeliver(deliver);
        return true;
    }

    @Override
    public List<Deliver> getDeliverByState(int state) {
        return deliverDao.getDeliverByState(state);
    }

    @Override
    public Deliver getDeliverById(int id) {
        return deliverDao.getDeliverById(id);
    }

    //    *****************************招聘信息**********
    @Override
    public boolean saveRecruit(Recruit recruit) {
        int row=recruitDao.saveRecruit(recruit);
        return true;
    }

    @Override
    public boolean delRecruit(int id) {
        int row=recruitDao.delRecruit(id);
        return true;
    }

    @Override
    public boolean updateRecruit(Recruit recruit) {
        int row=recruitDao.updateRecruit(recruit);
        return true;
    }

    @Override
    public List<Recruit> getRecruits() {
        return recruitDao.getRecruits();
    }

    @Override
    public Recruit getRecruitById(int id) {
        return recruitDao.getRecruitById(id);
    }

    //    ***************************部门***************************
    @Override
    public boolean saveDepartment(Department department) {
        int row = departmentDao.saveDepartment(department);
        return true;
    }

    @Override
    public boolean delDepartment(int id) {
        int row = departmentDao.delDepartment(id);
        return true;
    }

    @Override
    public boolean updateDepartment(Department department) {
        int row = departmentDao.updateDepartment(department);
        return true;
    }

    @Override
    public List<Department> getAllDepartment() {
        return departmentDao.getAllDepartment();
    }

    @Override
    public Department getDepartmentById(int id) {
        return departmentDao.getDepartmentById(id);
    }

    @Override
    public Department getDepartmentByName(String name) {
        return departmentDao.getDepartmentByName(name);
    }

    //    **************************职位*********************************
    @Override
    public boolean savePosition(Position position) {
        int row=positionDao.savePosition(position);
        return true;
    }

    @Override
    public boolean delPosition(int id) {
        int row=positionDao.delPosition(id);
        return true;
    }

    @Override
    public boolean updatePosition(Position position) {
        int row=positionDao.updatePosition(position);
        return true;
    }

    @Override
    public List<Position> getAllPosition() {
        return positionDao.getAllPosition();
    }

    @Override
    public Position getPositionById(int id) {
        return positionDao.getPositionById(id);
    }

    @Override
    public Position getPositionByName(String name) {
        return positionDao.getPositionByName(name);
    }

    //    ****************************员工*****************************
    @Override
    public boolean saveEmployee(Employee employee) {
        int row=employeeDao.saveEmployee(employee);
        return true;
    }

    @Override
    public boolean delEmployee(int id) {
        int row=employeeDao.delEmployee(id);
        return true;
    }

    @Override
    public boolean updateEmployee(Employee employee) {
        int row=employeeDao.updateEmployee(employee);
        return true;
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeDao.getAllEmployee();
    }

    @Override
    public List<Employee> getEmployeeByDid(int did) {
        return employeeDao.getEmployeeByDid(did);
    }

    @Override
    public Employee getEmployeeById(int id) {
        return employeeDao.getEmployeeById(id);
    }

    @Override
    public Employee getEmployeeByUser(String user) {
        return employeeDao.getEmployeeByUser(user);
    }

    @Override
    public Employee getEmployeeByUid(int uid) {
        return employeeDao.getEmployeeByUid(uid);
    }

    //    ****************************培训*****************************

    @Override
    public boolean saveTrain(Train train) {
        int row=trainDao.saveTrain(train);
        return true;
    }

    @Override
    public boolean delTrain(int id) {
        int row=trainDao.delTrain(id);
        return true;
    }

    @Override
    public boolean updateTrain(Train train) {
        int row=trainDao.updateTrain(train);
        return true;
    }

    @Override
    public List<Train> getAllTrain() {
        return trainDao.getAllTrain();
    }

    @Override
    public Train getTrainById(int id) {
        return trainDao.getTrainById(id);
    }

    //    *********培训记录**********

    @Override
    public boolean saveTrainRecord(TrainRecord trainRecord) {
        int row=trainRecordDao.saveTrainRecord(trainRecord);
        return true;
    }

    @Override
    public boolean delTrainRecord(int id) {
        int row=trainRecordDao.delTrainRecord(id);
        return true;
    }

    @Override
    public boolean updateTrainRecord(TrainRecord trainRecord) {
        int row=trainRecordDao.updateTrainRecord(trainRecord);
        return true;
    }

    @Override
    public List<TrainRecord> getAllTrainRecord() {
        return trainRecordDao.getAllTrainRecord();
    }

    @Override
    public TrainRecord getTrainRecordById(int id) {
        return trainRecordDao.getTrainRecordById(id);
    }

    @Override
    public List<TrainRecord> getTrainRecordByEid(int eid) {
        return trainRecordDao.getTrainRecordByEid(eid);
    }

    //******************************奖惩**************************
    @Override
    public boolean saveReward(Reward reward) {
        int row=rewardDao.saveReward(reward);
        return true;
    }

    @Override
    public boolean updateReward(Reward reward) {
        int row=rewardDao.updateReward(reward);
        return true;
    }

    @Override
    public List<Reward> getAllReward() {
        return rewardDao.getAllReward();
    }

    @Override
    public List<Reward> getRewardByEid(int eid) {
        return rewardDao.getRewardByEid(eid);
    }

    @Override
    public List<Reward> getRewardByEidAndTime(int eid, String time) {
        return rewardDao.getRewardByEidAndTime(eid, time);
    }

    @Override
    public Reward getRewardById(int id) {
        return rewardDao.getRewardById(id);
    }

    //******************************复议**************************

    @Override
    public boolean saveCheck(Check check) {
        int row=checkDao.saveCheck(check);
        return true;
    }

    @Override
    public boolean updateCheck(Check check) {
        int row=checkDao.updateCheck(check);
        return true;
    }

    @Override
    public List<Check> getCheckByState(int state) {
        return checkDao.getCheckByState(state);
    }

    @Override
    public Check getCheckById(int id) {
        return checkDao.getCheckById(id);
    }

    //******************薪资
    @Override
    public boolean saveSalary(Salary salary) {
        int row=salaryDao.saveSalary(salary);
        return true;
    }

    @Override
    public List<Salary> getSalaryByEid(int eid) {
        return salaryDao.getSalaryByEid(eid);
    }

    @Override
    public List<Salary> getSalaryByTime(String  time) {
        return salaryDao.getSalaryByTime(time);
    }

    @Override
    public Salary getSalaryByEidAndTime(int eid, String time) {
        return salaryDao.getSalaryByEidAndTime(eid, time);
    }

    @Override
    public List<Attend> getAttendsByEidAndMM(int eid, String yyyymm) {
        return attendDao.getAttendsByEidAndMM(eid, yyyymm);
    }
}
