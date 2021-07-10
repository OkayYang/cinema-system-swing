package com.yang;

import com.yang.dao.UserDao;
import com.yang.model.User;
import com.yang.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserTest {
    /**
     * 测试选择所有用户
     */
    @Test
    public void selectAllUsers(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<User> userList = userDao.selectAllUsers();
        for (User user:userList
             ) {
            System.out.println(user);
        }
    }
    /**
     * 选择指定用户
     * 增加一个用户
     */
    @Test
    public void selectUser(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User user = userDao.selectUser_byId(5001);
        System.out.println(user);
        user =userDao.selectUser_byName("华晨宇");
        System.out.println(user);
        user = new User();
        user.setUname("吴奇隆");
        user.setuPhone("1765552457");
        int success = userDao.addUser(user);
        System.out.println("成功插入"+success+"条数据!");
        sqlSession.commit();
    }
}
