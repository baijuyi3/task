package com.jy.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/11/1.
 */
public class Salary implements Serializable{
    private int id;
    private int e_id;
    private double base;
    private double bonus;
    private double extra;
    private double reward;
    private double safe;
    private String date;
    private double total;

    @Override
    public String toString() {
        return "Salary{" +
                "id=" + id +
                ", e_id=" + e_id +
                ", base=" + base +
                ", bonus=" + bonus +
                ", extra=" + extra +
                ", reward=" + reward +
                ", safe=" + safe +
                ", date='" + date + '\'' +
                '}';
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
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

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getExtra() {
        return extra;
    }

    public void setExtra(double extra) {
        this.extra = extra;
    }

    public double getReward() {
        return reward;
    }

    public void setReward(double reward) {
        this.reward = reward;
    }

    public double getSafe() {
        return safe;
    }

    public void setSafe(double safe) {
        this.safe = safe;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
