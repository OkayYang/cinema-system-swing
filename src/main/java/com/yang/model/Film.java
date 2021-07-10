package com.yang.model;

import java.util.Date;

public class Film {
    private int fid;
    private String fName;
    private String fType;
    private String fRegion;
    private String fDuration;
    private Date fDate;
    private double fPrice;

    public Film() {
    }

    public Film(String fName, String fType, String fRegion, String fDuration, Date fDate, double fPrice) {
        this.fName = fName;
        this.fType = fType;
        this.fRegion = fRegion;
        this.fDuration = fDuration;
        this.fDate = fDate;
        this.fPrice = fPrice;
    }

    public String getfType() {
        return fType;
    }

    public void setfType(String fType) {
        this.fType = fType;
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getfRegion() {
        return fRegion;
    }

    public void setfRegion(String fRegion) {
        this.fRegion = fRegion;
    }

    public String getfDuration() {
        return fDuration;
    }

    public void setfDuration(String fDuration) {
        this.fDuration = fDuration;
    }

    public Date getfDate() {
        return fDate;
    }

    public void setfDate(Date fDate) {
        this.fDate = fDate;
    }

    public double getfPrice() {
        return fPrice;
    }

    public void setfPrice(double fPrice) {
        this.fPrice = fPrice;
    }

    @Override
    public String toString() {
        return "Film{" +
                "fid=" + fid +
                ", fName='" + fName + '\'' +
                ", fType='" + fType + '\'' +
                ", fRegion='" + fRegion + '\'' +
                ", fDuration='" + fDuration + '\'' +
                ", fDate=" + fDate +
                ", fPrice=" + fPrice +
                '}';
    }
}
