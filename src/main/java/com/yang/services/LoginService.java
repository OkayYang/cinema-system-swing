package com.yang.services;

import com.yang.dao.AdminDao;
import com.yang.model.Admin;
import com.yang.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

public class LoginService {
    public static boolean adminLogin(String name,String password){
        boolean flag = false;
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        AdminDao adminDao = sqlSession.getMapper(AdminDao.class);
        Admin admin =adminDao.adminLogin(name,password);
        if (admin!=null){
            flag =true;
        }
        sqlSession.close();
        return flag;
    }
    public static boolean updateAdmin(String name,String password){
        boolean flag = false;
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        AdminDao adminDao = sqlSession.getMapper(AdminDao.class);
        int success= adminDao.updatePd(name,password);
        if (success==1){
            flag = true;
            sqlSession.commit();
        }
        sqlSession.close();
        return flag;
    }
}
