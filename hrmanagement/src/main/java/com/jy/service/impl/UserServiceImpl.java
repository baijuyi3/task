package com.jy.service.impl;

import com.jy.dao.ResumeDao;
import com.jy.dao.UserDao;
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
}
