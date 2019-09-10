package com.sky.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

//包间，卡座
public class Compartment {
    //编号
    private int compId;
    //包间名，卡座名
    private String compName;
    //状态
    private  String compState;
    //预定时间
    private Date reserve_date;
    //类型
    private int comptype;


    public Compartment() {
    }

    public Compartment(int compId,String compName, int comptype) {
        this.compId = compId;
        this.compName = compName;
        this.comptype = comptype;
    }

    public Compartment(int compId, String compState, Date reserve_date) {
        this.compId = compId;
        this.compState = compState;
        this.reserve_date = reserve_date;
    }

    public Compartment(int compId, String compName, String compState, Date reserve_date, int comptype) {
        this.compId = compId;
        this.compName = compName;
        this.compState = compState;
        this.reserve_date = reserve_date;
        this.comptype = comptype;
    }

    public Compartment(String compName, String compState, Date reserve_date, int comptype) {
        this.compName = compName;
        this.compState = compState;
        this.reserve_date = reserve_date;
        this.comptype = comptype;
    }

    public int getComptype() {
        return comptype;
    }

    public void setComptype(int comptype) {
        this.comptype = comptype;
    }

    public int getCompId() {
        return compId;
    }

    public void setCompId(int compId) {
        this.compId = compId;
    }

    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName;
    }

    public String getCompState() {
        return compState;
    }

    public void setCompState(String compState) {
        this.compState = compState;
    }


    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getReserve_date() {
        return reserve_date;
    }

    public void setReserve_date(Date reserve_date) {
        this.reserve_date = reserve_date;
    }

    @Override
    public String toString() {
        return "Compartment{" +
                "compId=" + compId +
                ", compName='" + compName + '\'' +
                ", compState='" + compState + '\'' +
                ", reserve_date=" + reserve_date +
                ", comptype=" + comptype +
                '}';
    }
}
