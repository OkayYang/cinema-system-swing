package com.yang.model;

public class User {
    private Integer uid;
    private String uname;
    private String uPhone;

    public User() {
    }

    public User(String uname, String uPhone) {
        this.uname = uname;
        this.uPhone = uPhone;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getuPhone() {
        return uPhone;
    }

    public void setuPhone(String uPhone) {
        this.uPhone = uPhone;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", uPhone='" + uPhone + '\'' +
                '}';
    }
}
