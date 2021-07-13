package com.yang.dao;

import com.yang.model.Order;
import com.yang.model.Order_infor;

import java.util.List;

public interface OrderDao {

    /**
     * 查看所有订单信息
     * @return
     */
    List<Order_infor> selectAllOrders();
    /**
     * 退票第一步
     * 通过order_id获取删除的订单对象
     * @param order_id
     * @return
     */
    Order selectOrder(int order_id);
    /**
     * 退票处理 第三步订单信息删除
     * @return
     */
    int deleteOrder(int order_id);

    int addOrder(Order order);
    List<Order_infor> selectOrders(String uname);


}
