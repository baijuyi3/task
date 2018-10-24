package com.jy.service.impl;

import com.jy.dao.DeliverDao;
import com.jy.dao.RecruitDao;
import com.jy.dao.ResumeDao;
import com.jy.dao.UserDao;
import com.jy.model.Deliver;
import com.jy.model.Recruit;
import com.jy.model.Resume;
import com.jy.model.User;
import com.jy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/10/20.
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;
    @Autowired
    private ResumeDao resumeDao;
    @Autowired
    private DeliverDao deliverDao;
    @Autowired
    private RecruitDao recruitDao;
    @Override
    //    *******************用户*********************
    public User getUserByNameAndPass(User user) {
        if(user==null){
            return null;
        }
        User user1=userDao.getUserByNameAndPass(user);
        return user1;
    }

    @Override
    public boolean addUser(User user) {
        if(user==null){
            return false;
        }
        int row=userDao.addUser(user);
        if(0!=row){
            return true;
        }
        return false;
    }

//    ************************简历**************************

    @Override
    public boolean saveResume(Resume resume) {
        if(resume==null){
            return false;
        }
        int row=resumeDao.saveResume(resume);
        if(0!=row){
            return true;
        }
        return false;
    }

    @Override
    public boolean delResume(int id) {
        if(id==0){
            return false;
        }
        int row=resumeDao.delResume(id);
        if(0!=row){
            return true;
        }
        return false;
    }

    @Override
    public boolean updateResume(Resume resume) {
        if(resume==null){
            return false;
        }
        int row=resumeDao.updateResume(resume);
        if(0!=row){
            return true;
        }
        return false;
    }

    @Override
    public List<Resume> getResumeByUid(int uid) {
        return resumeDao.getResumeByUid(uid);
    }

    @Override
    public Resume getResumeById(int id) {
        return resumeDao.getResumeById(id);
    }

//    ************************投递*************************
    @Override
    public boolean saveDeliver(Deliver deliver) {
        if(deliver==null){
            return false;
        }
        int row=deliverDao.saveDeliver(deliver);
        if(0!=row){
            return true;
        }
        return false;
    }

    @Override
    public boolean delDeliver(int id) {
        if(id==0){
            return false;
        }
        int row=deliverDao.delDeliver(id);
        if(0!=row){
            return true;
        }
        return false;
    }

    @Override
    public boolean updateDeliver(Deliver deliver) {
        if(deliver==null){
            return false;
        }
        int row=deliverDao.updateDeliver(deliver);
        if(0!=row){
            return true;
        }
        return false;
    }

    @Override
    public List<Deliver> getDeliverByState(int state) {
        return deliverDao.getDeliverByState(state);
    }

    @Override
    public List<Deliver> getDeliverByUid(int u_id) {
        return deliverDao.getDeliverByUid(u_id);
    }

    @Override
    public List<Deliver> getDeliverByUidAndState(int u_id, int state) {
        return deliverDao.getDeliverByUidAndState(u_id,state);
    }

    @Override
    public Deliver getDeliverByUidAndRcid(int u_id, int rc_id) {
        return deliverDao.getDeliverByUidAndRcid(u_id, rc_id);
    }

    //**********************招聘信息***********************
    @Override
    public List<Recruit> getRecruits() {
        return recruitDao.getRecruits();
    }
}
