package com.yang;

import static org.junit.Assert.assertTrue;

import com.yang.dao.AdminDao;
import com.yang.model.Admin;
import com.yang.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

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
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        AdminDao adminDao = sqlSession.getMapper(AdminDao.class);
        Admin admin =adminDao.adminLogin("admin","123456");
        if (admin!=null){
            System.out.println(admin.getAdmin_name());
        }else {
            System.out.println("账号或密码错误");
        }
        sqlSession.close();
    }
    /**
     * 测试修改管理员密码，输入管理员名称即可
     */
    @Test
    public void updateAdminTest(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        AdminDao adminDao = sqlSession.getMapper(AdminDao.class);
        int success= adminDao.updatePd("admin","123456");
        if (success==1){
            System.out.println("密码更改成功!");
        }
        sqlSession.commit();
        sqlSession.close();
    }
}
