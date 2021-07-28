package com.yang;

import static org.junit.Assert.assertTrue;

import com.yang.dao.AdminDao;
import com.yang.model.Admin;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Unit test for simple App.
 */
public class AdminTest
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
    /**
     * 测试管理员登录
     */
    @Test
    public void adminLoginTest(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        AdminDao adminDao = (AdminDao) applicationContext.getBean("adminDao");
        Admin admin =adminDao.adminLogin("admin","123456");
        if (admin!=null){
            System.out.println(admin.getAdmin_name());
        }else {
            System.out.println("账号或密码错误");
        }
    }
    /**
     * 测试修改管理员密码，输入管理员名称即可
     */
    @Test
    public void updateAdminTest(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        AdminDao adminDao = (AdminDao) applicationContext.getBean("adminDao");
        int success= adminDao.updatePd("admin","123456");
        if (success==1){
            System.out.println("密码更改成功!");
        }

    }
}
