package com.yang.service.Impl;

import com.yang.dao.OrderDao;
import com.yang.dao.SchedulDao;
import com.yang.dao.UserDao;
import com.yang.model.Order;
import com.yang.model.Schedul;
import com.yang.model.Schedul_infor;
import com.yang.model.User;
import com.yang.service.SchedulService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service("schedulService")
public class SchedulServiceImpl implements SchedulService {
    @Autowired
    private SchedulDao schedulDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private OrderDao orderDao;
    public  Object[][] showFilmInfor(){
        Object[][] objects=null;
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
        return objects;
    }

    //需要事务
    @Transactional
    public   Boolean  buyTicket(String name,String phone,int fid){
        boolean flag = false;

        schedulDao.updateStock(fid);


        User user = userDao.selectUser_byName(name);
        if (user == null) {
            user = new User();
            user.setUname(name);
            user.setuPhone(phone);
            userDao.addUser(user);
            user = userDao.selectUser_byName(name);
        }
        Order order = new Order(user.getUid(),fid,new Date());

        if (orderDao.addOrder(order)!=0){
            flag=true;
        }
        return flag;
    }


    public  String[] showSid(){

        List<Schedul_infor> schedulInforList = schedulDao.selectAllScheduls();
        String[] str= new String[schedulInforList.size()];
        for (int i = 0; i < schedulInforList.size(); i++) {
            str[i] = ""+schedulInforList.get(i).getSid();
        }
        return str;


    }

    public  boolean addSchedul(Schedul schedul){
        boolean flag = false;
        if (schedulDao.addSchedul(schedul) != 0) {
            flag = true;
        }
        return flag;
    }

    public  boolean delSchedul(int sid){
        boolean flag = false;
        if (schedulDao.deletesSchedul(sid)!=0){
            flag = true;
        }
        return flag;
    }
    public  Object[][] findSheduls(String sname){
        Object[][] objects=null;
        List<Schedul_infor> schedulInforList = schedulDao.findScheduls(sname);
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
        return objects;
    }



}
