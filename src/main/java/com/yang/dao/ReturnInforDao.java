package com.yang.dao;

import com.yang.model.Order;
import com.yang.model.Return_order_infor;

import java.util.List;

public interface ReturnInforDao {
    /**
     * 删除订单第二步先把要删除的信息加入删除表中
     * @param order
     * @return
     */
    int insertReturnInfor(Order order);

    List<Return_order_infor> selectAllReturns();
    List<Return_order_infor> findReturns(String uname);
}
