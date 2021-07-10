package com.yang.services;

import com.yang.dao.OrderDao;
import com.yang.dao.SchedulDao;
import com.yang.dao.UserDao;
import com.yang.model.Order;
import com.yang.model.Schedul_infor;
import com.yang.model.User;
import com.yang.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class SchedulService {
    public static Object[][] showFilmInfor(){
        Object[][] objects=null;
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        SchedulDao schedulDao = sqlSession.getMapper(SchedulDao.class);
        List<Schedul_infor> schedulInforList = schedulDao.selectAllScheduls();
        SimpleDateFormat sdf =new SimpleDateFormat("yyy-MM-dd HH:mm");
        if (schedulInforList.size()!=0){
            objects =new Object[schedulInforList.size()][];
            for (int i = 0; i < schedulInforList.size(); i++) {
                objects[i] = new Object[]{
                        schedulInforList.get(i).getSid(),
                        schedulInforList.get(i).getsName(),
                        schedulInforList.get(i).getfName(),
                        schedulInforList.get(i).getfType(),
                        schedulInforList.get(i).getfDuration(),
                        sdf.format(schedulInforList.get(i).getsTime()),
                        schedulInforList.get(i).getsStock()
                };
            }
        }
sqlSession.close();
        return objects;
    }

    public static  Boolean  addTicket(String name,String phone,int fid){
        boolean flag = false;
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        SchedulDao schedulDao = sqlSession.getMapper(SchedulDao.class);
        schedulDao.updateStock(fid);

        UserDao userDao = sqlSession.getMapper(UserDao.class);

        User user = userDao.selectUser_byName(name);
        if (user == null) {
            user = new User();
            user.setUname(name);
            user.setuPhone(phone);
            userDao.addUser(user);
            user = userDao.selectUser_byName(name);
        }
        Order order = new Order(user.getUid(),fid,new Date());
        OrderDao orderDao = sqlSession.getMapper(OrderDao.class);
        if (orderDao.addOrder(order)!=0){
            sqlSession.commit();
            flag=true;
        }
        sqlSession.close();

        return flag;



    }


}
