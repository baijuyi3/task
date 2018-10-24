package com.jy.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/10/24.
 */
public class Position implements Serializable {
    private int id;
    private String name;
    private int dp_id;

    @Override
    public String toString() {
        return "Position{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dp_id=" + dp_id +
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

    public int getDp_id() {
        return dp_id;
    }

    public void setDp_id(int dp_id) {
        this.dp_id = dp_id;
    }
}
