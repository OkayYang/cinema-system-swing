package com.yang.services;

import com.yang.dao.OrderDao;
import com.yang.dao.ReturnInforDao;
import com.yang.model.Order;
import com.yang.model.Order_infor;
import com.yang.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class OrderInforService {
    public static Object[][] showOrderInfor(){
        Object[][] objects=null;
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        OrderDao orderDao = sqlSession.getMapper(OrderDao.class);
        List<Order_infor> order_inforList = orderDao.selectAllOrders();
        SimpleDateFormat sdf =new SimpleDateFormat("yyy-MM-dd HH:mm");
        if (order_inforList.size()!=0){
            objects =new Object[order_inforList.size()][];
            for (int i = 0; i < order_inforList.size(); i++) {
                objects[i] = new Object[]{

                        order_inforList.get(i).getOid(),
                        order_inforList.get(i).getUname(),
                        order_inforList.get(i).getFname(),
                        order_inforList.get(i).getSname(),
                        sdf.format(order_inforList.get(i).getStime()),
                        sdf.format(order_inforList.get(i).getBtime())
                };
            }
        }
        sqlSession.close();

        return objects;
    }
    public static int getInfornum(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        OrderDao orderDao = sqlSession.getMapper(OrderDao.class);
        List<Order_infor> order_inforList = orderDao.selectAllOrders();
        sqlSession.close();
        return order_inforList.size();
    }
    public static boolean returnMoney(int oid){
        boolean flag = false;
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        OrderDao orderDao = sqlSession.getMapper(OrderDao.class);
        Order order = orderDao.selectOrder(oid);
        if (order!=null){
            System.out.println(order);
            Date date = new Date();
            SimpleDateFormat sdf =new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
            order.setBuying_time(date);
            ReturnInforDao returnInforDao =sqlSession.getMapper(ReturnInforDao.class);
            returnInforDao.insertReturnInfor(order);
            orderDao.deleteOrder(oid);
            flag=true;
        }
        sqlSession.commit();
        sqlSession.close();
        return flag;
    }
    public static Object[][] findOrder(String uname){
        Object[][] objects=null;
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        OrderDao orderDao = sqlSession.getMapper(OrderDao.class);
        List<Order_infor> order_inforList = orderDao.selectOrders(uname);
        SimpleDateFormat sdf =new SimpleDateFormat("yyy-MM-dd HH:mm");
        if (order_inforList.size()!=0){
            objects =new Object[order_inforList.size()][];
            for (int i = 0; i < order_inforList.size(); i++) {
                objects[i] = new Object[]{
                        order_inforList.get(i).getOid(),
                        order_inforList.get(i).getUname(),
                        order_inforList.get(i).getFname(),
                        order_inforList.get(i).getSname(),
                        sdf.format(order_inforList.get(i).getStime()),
                        sdf.format(order_inforList.get(i).getBtime())
                };
            }
        }
        sqlSession.close();
        return objects;
    }

}
