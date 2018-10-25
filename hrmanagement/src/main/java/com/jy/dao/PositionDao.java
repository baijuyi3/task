package com.jy.dao;

import com.jy.model.Position;

import java.util.List;

/**
 * Created by Administrator on 2018/10/25.
 */
public interface PositionDao {
    int savePosition(Position position);
    int delPosition(int id);
    int updatePosition(Position position);
    List<Position> getAllPosition();
    Position getPositionById(int id);
}
