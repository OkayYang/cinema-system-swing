package com.yang;

import com.yang.dao.OrderDao;
import com.yang.dao.ReturnInforDao;
import com.yang.model.Order;
import com.yang.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RreturnOrderTest {
    @Test
    public void returnTest(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        OrderDao orderDao = sqlSession.getMapper(OrderDao.class);
        Order order = orderDao.selectOrder(10009);
        if (order!=null){
            System.out.println(order);
            Date date = new Date();
            SimpleDateFormat sdf =new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
            order.setBuying_time(date);
            ReturnInforDao returnInforDao =sqlSession.getMapper(ReturnInforDao.class);
            int success = returnInforDao.insertReturnInfor(order);
            System.out.println("成功插入退款"+success+"条数据");
            success =orderDao.deleteOrder(10009);
            System.out.println("成功删除退款"+success+"条数据");
        }
        sqlSession.commit();
    }


}
