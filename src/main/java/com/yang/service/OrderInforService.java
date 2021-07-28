package com.yang.service;

public interface OrderInforService {
    Object[][] showOrderInfor();
    int getInfornum();
    boolean returnMoney(int oid);
    Object[][] findOrder(String uname);
}
