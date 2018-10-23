package com.jy.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/10/23.
 */
public class Recruit implements Serializable {
    private int id;
    private String name;
    private String salary;
    private String place;
    private String eduction;
    private String work_time;
    private String time;
    private String callback;
    private String company;
    private String style;
    private String welfare;
    private String sign;

    @Override
    public String toString() {
        return "Recruit{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary='" + salary + '\'' +
                ", place='" + place + '\'' +
                ", eduction='" + eduction + '\'' +
                ", work_time='" + work_time + '\'' +
                ", time='" + time + '\'' +
                ", callback='" + callback + '\'' +
                ", company='" + company + '\'' +
                ", style='" + style + '\'' +
                ", welfare='" + welfare + '\'' +
                ", sign='" + sign + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getEduction() {
        return eduction;
    }

    public void setEduction(String eduction) {
        this.eduction = eduction;
    }

    public String getWork_time() {
        return work_time;
    }

    public void setWork_time(String work_time) {
        this.work_time = work_time;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCallback() {
        return callback;
    }

    public void setCallback(String callback) {
        this.callback = callback;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getWelfare() {
        return welfare;
    }

    public void setWelfare(String welfare) {
        this.welfare = welfare;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
