package com.yang.model;

import java.util.Date;

public class Schedul_infor {
    private int sid;
    private String sName;
    private String fName;
    private String fType;
    private String fDuration;
    private Date sTime;
    private int sStock;

    public Schedul_infor() {
    }

    public Schedul_infor(String sName, String fName, String fType, String fDuration, Date sTime, int sStock) {
        this.sName = sName;
        this.fName = fName;
        this.fType = fType;
        this.fDuration = fDuration;
        this.sTime = sTime;
        this.sStock = sStock;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getfType() {
        return fType;
    }

    public void setfType(String fType) {
        this.fType = fType;
    }

    public String getfDuration() {
        return fDuration;
    }

    public void setfDuration(String fDuration) {
        this.fDuration = fDuration;
    }

    public Date getsTime() {
        return sTime;
    }

    public void setsTime(Date sTime) {
        this.sTime = sTime;
    }

    public int getsStock() {
        return sStock;
    }

    public void setsStock(int sStock) {
        this.sStock = sStock;
    }

    @Override
    public String toString() {
        return "Schedul{" +
                "sid=" + sid +
                ", sName='" + sName + '\'' +
                ", fName='" + fName + '\'' +
                ", fType='" + fType + '\'' +
                ", fDuration='" + fDuration + '\'' +
                ", sTime=" + sTime +
                ", sStock=" + sStock +
                '}';
    }
}
