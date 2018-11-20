package com.jy.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2018/10/31.
 */
public class Reward implements Serializable {
    private int id;
    private String reason;
    private double money;
    private int e_id;
    private String date;

    @Override
    public String toString() {
        return "Reward{" +
                "id=" + id +
                ", reason='" + reason + '\'' +
                ", money=" + money +
                ", e_id=" + e_id +
                ", date=" + date +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public int getE_id() {
        return e_id;
    }

    public void setE_id(int e_id) {
        this.e_id = e_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
