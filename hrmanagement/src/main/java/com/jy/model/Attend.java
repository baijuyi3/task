package com.jy.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2018/10/31.
 */
public class Attend implements Serializable {
    private int id;
    private int e_id;
    private Date morning;
    private Date afternoon;

    @Override
    public String toString() {
        return "Attend{" +
                "id=" + id +
                ", e_id=" + e_id +
                ", morning=" + morning +
                ", afternoon=" + afternoon +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getE_id() {
        return e_id;
    }

    public void setE_id(int e_id) {
        this.e_id = e_id;
    }

    public Date getMorning() {
        return morning;
    }

    public void setMorning(Date morning) {
        this.morning = morning;
    }

    public Date getAfternoon() {
        return afternoon;
    }

    public void setAfternoon(Date afternoon) {
        this.afternoon = afternoon;
    }
}
