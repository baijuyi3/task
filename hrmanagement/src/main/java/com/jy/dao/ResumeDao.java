package com.jy.dao;

import com.jy.model.Resume;

import java.util.List;

/**
 * Created by Administrator on 2018/10/22.
 */
public interface ResumeDao {
    int saveResume(Resume resume);
    int delResume(Resume resume);
    int updateResume(Resume resume);
    List<Resume> getResumeByUid(int uid);
    Resume getResumeById(int id);
}
