package com.yang.dao;

import com.yang.model.Admin;
import org.apache.ibatis.annotations.Param;

public interface AdminDao {
    /**
     * 管理员登录
     * @param admin_name  管理员账号
     * @param admin_password  管理员密码
     * @return
     */
    Admin adminLogin(@Param("aname") String admin_name, @Param("apd") String admin_password);

    /**
     * 更改密码
     * @param admin_name  要更改的管理员账号
     * @param new_password  更改的新密码
     * @return
     */
    int updatePd(@Param("aname") String admin_name, @Param("newPd") String new_password);
}
