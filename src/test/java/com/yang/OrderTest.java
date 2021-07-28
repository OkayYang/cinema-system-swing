package com.yang;

import com.yang.dao.FilmDao;
import com.yang.dao.OrderDao;
import com.yang.model.Order_infor;
import com.yang.service.OrderInforService;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class OrderTest {
    /**
     * 查询所有订单
     */
    @Test
    public void selectAllOrders(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        OrderDao orderDao = (OrderDao) applicationContext.getBean("orderDao");
        List<Order_infor> order_inforList = orderDao.selectAllOrders();
        for (Order_infor orderInfor:order_inforList
             ) {
            System.out.println(orderInfor);
        }
    }
    @Test
    public void returnMoney(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        OrderInforService orderInforService = (OrderInforService) applicationContext.getBean("orderInforService");
        orderInforService.returnMoney(521);

    }
}
