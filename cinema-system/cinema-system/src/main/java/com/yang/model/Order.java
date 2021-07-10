package com.yang.model;

import java.util.Date;

public class Order {
    private int order_id;
    private int user_id;
    private int schedul_id;
    private Date buying_time;

    public Order() {
    }

    public Order( int user_id, int schedul_id, Date buying_time) {

        this.user_id = user_id;
        this.schedul_id = schedul_id;
        this.buying_time = buying_time;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getSchedul_id() {
        return schedul_id;
    }

    public void setSchedul_id(int schedul_id) {
        this.schedul_id = schedul_id;
    }

    public Date getBuying_time() {
        return buying_time;
    }

    public void setBuying_time(Date buying_time) {
        this.buying_time = buying_time;
    }

    @Override
    public String toString() {
        return "Order{" +
                "order_id=" + order_id +
                ", user_id=" + user_id +
                ", schedul_id=" + schedul_id +
                ", buying_time=" + buying_time +
                '}';
    }
}
