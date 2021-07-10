package com.yang.dao;

import com.yang.model.Schedul;
import com.yang.model.Schedul_infor;

import java.util.List;

public interface SchedulDao {
    List<Schedul_infor> selectAllScheduls();
    int addSchedul(Schedul schedul);
    int updateStock(int sid);
}
