package com.yang;

import com.yang.dao.FilmDao;
import com.yang.dao.OrderDao;
import com.yang.dao.ReturnInforDao;
import com.yang.model.Order;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RreturnOrderTest {
    @Test
    public void returnTest(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        OrderDao orderDao = (OrderDao)applicationContext.getBean("orderDao");
        Order order = orderDao.selectOrder(10009);
        if (order!=null){
            System.out.println(order);
            Date date = new Date();
            SimpleDateFormat sdf =new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
            order.setBuying_time(date);
            ReturnInforDao returnInforDao =(ReturnInforDao) applicationContext.getBean("returnInforDao");
            int success = returnInforDao.insertReturnInfor(order);
            System.out.println("成功插入退款"+success+"条数据");
            success =orderDao.deleteOrder(10009);
            System.out.println("成功删除退款"+success+"条数据");
        }
    }


}
