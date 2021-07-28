package com.yang.service.Impl;

import com.yang.dao.OrderDao;
import com.yang.dao.ReturnInforDao;
import com.yang.model.Order;
import com.yang.model.Order_infor;
import com.yang.service.OrderInforService;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service("orderInforService")
public class OrderInforServiceImpl implements OrderInforService {
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private ReturnInforDao returnInforDao;
    public Object[][] showOrderInfor(){
        Object[][] objects=null;
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

        return objects;
    }
    public  int getInfornum(){

        List<Order_infor> order_inforList = orderDao.selectAllOrders();
        return order_inforList.size();
    }
    //需要添加事务功能
    @Transactional
    public  boolean returnMoney(int oid){
        boolean flag = false;
        Order order = orderDao.selectOrder(oid);
        if (order!=null){
            System.out.println(order);
            Date date = new Date();
            SimpleDateFormat sdf =new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
            order.setBuying_time(date);
            returnInforDao.insertReturnInfor(order);
            orderDao.deleteOrder(oid);
            flag=true;
        }
        return flag;
    }
    public  Object[][] findOrder(String uname){
        Object[][] objects=null;
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
        return objects;
    }

}
