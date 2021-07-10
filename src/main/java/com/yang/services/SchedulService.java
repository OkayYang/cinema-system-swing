package com.yang.services;

import com.yang.dao.SchedulDao;
import com.yang.model.Schedul_infor;
import com.yang.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.text.SimpleDateFormat;
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
}
