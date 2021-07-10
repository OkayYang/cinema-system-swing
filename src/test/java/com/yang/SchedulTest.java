package com.yang;

import com.yang.dao.OrderDao;
import com.yang.dao.SchedulDao;
import com.yang.dao.UserDao;
import com.yang.model.Order;
import com.yang.model.Schedul;
import com.yang.model.Schedul_infor;
import com.yang.model.User;
import com.yang.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class SchedulTest {
    @Test
    public void schedulTest(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        SchedulDao schedulDao = sqlSession.getMapper(SchedulDao.class);
        List<Schedul_infor> schedulInforList = schedulDao.selectAllScheduls();
        for (Schedul_infor schedulInfor: schedulInforList
             ) {
            System.out.println(schedulInfor);
        }
        Schedul schedul = new Schedul("IMAX3D-1号厅",11107,new Date(),60);
        schedulDao.addSchedul(schedul);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void buySchedule(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        SchedulDao schedulDao = sqlSession.getMapper(SchedulDao.class);
        schedulDao.updateStock(6001);

        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User user = userDao.selectUser_byName("张三");
        if (user == null) {
            user = new User();
            user.setUname("张三");
            user.setuPhone("17633505913");
            userDao.addUser(user);
            user = userDao.selectUser_byName("张三");
        }
        Order order = new Order(user.getUid(),6001,new Date());
        OrderDao orderDao = sqlSession.getMapper(OrderDao.class);
        orderDao.addOrder(order);
        sqlSession.commit();
        System.out.println("购票成功!");
    }
}
