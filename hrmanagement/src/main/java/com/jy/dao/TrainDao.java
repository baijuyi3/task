package com.jy.dao;

import com.jy.model.Train;

import java.util.List;

/**
 * Created by Administrator on 2018/10/31.
 */
public interface TrainDao {
    int saveTrain(Train train);
    int delTrain(int id);
    int updateTrain(Train train);
    List<Train> getAllTrain();
    Train getTrainById(int id);
}
