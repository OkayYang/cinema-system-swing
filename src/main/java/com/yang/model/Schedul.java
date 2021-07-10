package com.yang.model;

import java.util.Date;

public class Schedul {
    private  int sid;
    private String sName;
    private int fid;
    private Date sTime;
    private int sStock;

    public Schedul() {
    }

    public Schedul(String sName, int fid, Date sTime, int sStock) {
        this.sName = sName;
        this.fid = fid;
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

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
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
                ", fid=" + fid +
                ", sTime=" + sTime +
                ", sStock=" + sStock +
                '}';
    }
}
