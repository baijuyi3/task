package com.jy.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/11/1.
 */
public class Check implements Serializable {
    private int id;
    private int r_id;
    private int e_id;
    private String reason;
    private int state;

    @Override
    public String toString() {
        return "Check{" +
                "id=" + id +
                ", r_id=" + r_id +
                ", e_id=" + e_id +
                ", reason='" + reason + '\'' +
                ", state=" + state +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getR_id() {
        return r_id;
    }

    public void setR_id(int r_id) {
        this.r_id = r_id;
    }

    public int getE_id() {
        return e_id;
    }

    public void setE_id(int e_id) {
        this.e_id = e_id;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
