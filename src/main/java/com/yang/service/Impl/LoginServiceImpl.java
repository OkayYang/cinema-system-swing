package com.yang.service.Impl;

import com.yang.dao.AdminDao;
import com.yang.model.Admin;
import com.yang.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("loginService")
public class LoginServiceImpl implements LoginService {
    @Autowired
    private AdminDao adminDao;
    public  boolean adminLogin(String name,String password){
        boolean flag = false;

        Admin admin =adminDao.adminLogin(name,password);
        if (admin!=null){
            flag =true;
        }
        return flag;
    }
    public  boolean updateAdmin(String name,String password){
        boolean flag = false;
        int success= adminDao.updatePd(name,password);
        if (success==1){
            flag = true;

        }
        return flag;
    }
}
