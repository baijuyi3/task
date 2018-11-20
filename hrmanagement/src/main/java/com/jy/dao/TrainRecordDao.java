package com.jy.dao;

import com.jy.model.TrainRecord;

import java.util.List;

/**
 * Created by Administrator on 2018/10/31.
 */
public interface TrainRecordDao {
    int saveTrainRecord(TrainRecord trainRecord);
    int delTrainRecord(int id);
    int updateTrainRecord(TrainRecord trainRecord);
    List<TrainRecord> getAllTrainRecord();
    TrainRecord getTrainRecordById(int id);
    List<TrainRecord> getTrainRecordByEid(int eid);
}
