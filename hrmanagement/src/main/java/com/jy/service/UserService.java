package com.jy.service;

import com.jy.model.Deliver;
import com.jy.model.Recruit;
import com.jy.model.Resume;
import com.jy.model.User;

import java.util.List;

/**
 * Created by Administrator on 2018/10/20.
 */
public interface UserService {
    User getUserByNameAndPass(User user);
    boolean addUser(User user);
//**********************简历***********************
    boolean saveResume(Resume resume);
    boolean delResume(int id);
    boolean updateResume(Resume resume);
    List<Resume> getResumeByUid(int uid);
    Resume getResumeById(int id);
//**********************投递***********************
    boolean saveDeliver(Deliver deliver);
    boolean delDeliver(int id);
    boolean updateDeliver(Deliver deliver);
    List<Deliver> getDeliverByState(int state);
    List<Deliver> getDeliverByUid(int u_id);
    List<Deliver> getDeliverByUidAndState(int u_id,int state);
    Deliver getDeliverByUidAndRcid(int u_id,int rc_id);
//**********************招聘信息***********************
    List<Recruit> getRecruits();

}
