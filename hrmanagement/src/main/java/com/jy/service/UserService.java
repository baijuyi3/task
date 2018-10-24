package com.jy.service;

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
}
