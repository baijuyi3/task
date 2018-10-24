package com.jy.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/10/24.
 */
public class Deliver implements Serializable {
    private int id;
    private int rc_id;
    private int r_id;
    private int state;
    private String date;
    private String interv_date;
    private String place;
    private int u_id;
    private String rc_name;
    @Override
    public String toString() {
        return "Deliver{" +
                "id=" + id +
                ", rc_id=" + rc_id +
                ", r_id=" + r_id +
                ", state=" + state +
                ", date='" + date + '\'' +
                ", interv_date='" + interv_date + '\'' +
                ", place='" + place + '\'' +
                ", u_id='" + u_id + '\'' +
                ", rc_name='" + rc_name + '\'' +
                '}';
    }

    public String getRc_name() {
        return rc_name;
    }

    public void setRc_name(String rc_name) {
        this.rc_name = rc_name;
    }

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRc_id() {
        return rc_id;
    }

    public void setRc_id(int rc_id) {
        this.rc_id = rc_id;
    }

    public int getR_id() {
        return r_id;
    }

    public void setR_id(int r_id) {
        this.r_id = r_id;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getInterv_date() {
        return interv_date;
    }

    public void setInterv_date(String interv_date) {
        this.interv_date = interv_date;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}
