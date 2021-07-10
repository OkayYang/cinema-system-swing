package com.yang;

import com.yang.dao.OrderDao;
import com.yang.model.Order_infor;
import com.yang.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class OrderTest {
    /**
     * 查询所有订单
     */
    @Test
    public void selectAllOrders(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        OrderDao orderDao = sqlSession.getMapper(OrderDao.class);
        List<Order_infor> order_inforList = orderDao.selectAllOrders();
        for (Order_infor orderInfor:order_inforList
             ) {
            System.out.println(orderInfor);
        }
    }
}
