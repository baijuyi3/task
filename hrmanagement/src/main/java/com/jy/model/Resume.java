package com.jy.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/10/22.
 */
public class Resume implements Serializable {
   /* R_ID NUMBER(20) not null
    primary key,
    R_NAME VARCHAR2(20) not null,
    R_BIRTH VARCHAR2(20) not null,
    R_PHONE VARCHAR2(100) not null,
    R_MAIL VARCHAR2(100) not null,
    R_STARTWORK VARCHAR2(20) not null,
    R_STATE VARCHAR2(20) not null,
    R_LIVE VARCHAR2(20) not null,
    R_SALARY NUMBER(20,2),
    R_AIM_SALARY NUMBER(20,2) not null,
    R_AIM_WORKSPACE VARCHAR2(20) not null,
    R_AIM_WORK VARCHAR2(100) not null,
    R_AIM_PROFESSION VARCHAR2(100),
    R_AIM_INTRODUCE VARCHAR2(500),
    R_AIM_WORKTIME VARCHAR2(100),
    R_AIM_WORKSTYLE VARCHAR2(20),
    R_HEADPICTURE VARCHAR2(100)*/
   private int id;
   private String name;
   private String birth;
   private String phone;
   private String mail;
   private String startwork;
   private String state;
   private String live;
   private String salary;
   private String aim_salary;
   private String aim_workspace;
   private String aim_work;
   private String aim_profession;
   private String aim_introduce;
   private String aim_worktime;
   private String aim_workstyle;
   private String headpicture;
   private int uid;
   private String sex;
   private String r_name;

    @Override
    public String toString() {
        return "Resume{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birth='" + birth + '\'' +
                ", phone='" + phone + '\'' +
                ", mail='" + mail + '\'' +
                ", startwork='" + startwork + '\'' +
                ", state='" + state + '\'' +
                ", live='" + live + '\'' +
                ", salary='" + salary + '\'' +
                ", aim_salary='" + aim_salary + '\'' +
                ", aim_workspace='" + aim_workspace + '\'' +
                ", aim_work='" + aim_work + '\'' +
                ", aim_profession='" + aim_profession + '\'' +
                ", aim_introduce='" + aim_introduce + '\'' +
                ", aim_worktime='" + aim_worktime + '\'' +
                ", aim_workstyle='" + aim_workstyle + '\'' +
                ", headpicture='" + headpicture + '\'' +
                ", uid=" + uid +
                ", sex=" + sex +
                ", r_name=" + r_name +
                '}';
    }

    public String getR_name() {
        return r_name;
    }

    public void setR_name(String r_name) {
        this.r_name = r_name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
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

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getStartwork() {
        return startwork;
    }

    public void setStartwork(String startwork) {
        this.startwork = startwork;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getLive() {
        return live;
    }

    public void setLive(String live) {
        this.live = live;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getAim_salary() {
        return aim_salary;
    }

    public void setAim_salary(String aim_salary) {
        this.aim_salary = aim_salary;
    }

    public String getAim_workspace() {
        return aim_workspace;
    }

    public void setAim_workspace(String aim_workspace) {
        this.aim_workspace = aim_workspace;
    }

    public String getAim_work() {
        return aim_work;
    }

    public void setAim_work(String aim_work) {
        this.aim_work = aim_work;
    }

    public String getAim_profession() {
        return aim_profession;
    }

    public void setAim_profession(String aim_profession) {
        this.aim_profession = aim_profession;
    }

    public String getAim_introduce() {
        return aim_introduce;
    }

    public void setAim_introduce(String aim_introduce) {
        this.aim_introduce = aim_introduce;
    }

    public String getAim_worktime() {
        return aim_worktime;
    }

    public void setAim_worktime(String aim_worktime) {
        this.aim_worktime = aim_worktime;
    }

    public String getAim_workstyle() {
        return aim_workstyle;
    }

    public void setAim_workstyle(String aim_workstyle) {
        this.aim_workstyle = aim_workstyle;
    }

    public String getHeadpicture() {
        return headpicture;
    }

    public void setHeadpicture(String headpicture) {
        this.headpicture = headpicture;
    }
}
