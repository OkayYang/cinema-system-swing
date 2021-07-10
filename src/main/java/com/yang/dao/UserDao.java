package com.yang.dao;

import com.yang.model.User;

import java.util.List;

public interface UserDao {
    /**
     * 查看所有用户
     * @return
     */
    List<User> selectAllUsers();

    /**
     * 通过uid查找用户
     * @param uid
     * @return
     */
    User selectUser_byId(int uid);

    /**
     * 通过用户名查找用户
     * @param uname
     * @return
     */
    User selectUser_byName(String uname);

    /**
     * 添加一条用户信息
     * @param user
     * @return
     */
    int addUser(User user);

    /**
     * 删除一条用户信息
     * @param uid
     * @return
     */
    int deleteUser(int uid);

}
