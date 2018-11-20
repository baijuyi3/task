package com.jy.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/10/31.
 */
public class TrainRecord implements Serializable {
    private int id;
    private int t_id;
    private int e_id;
    private int state;

    @Override
    public String toString() {
        return "TrainRecord{" +
                "id=" + id +
                ", t_id=" + t_id +
                ", e_id=" + e_id +
                ", state=" + state +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getT_id() {
        return t_id;
    }

    public void setT_id(int t_id) {
        this.t_id = t_id;
    }

    public int getE_id() {
        return e_id;
    }

    public void setE_id(int e_id) {
        this.e_id = e_id;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
