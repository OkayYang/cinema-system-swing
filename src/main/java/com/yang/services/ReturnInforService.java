package com.yang.services;

import com.yang.dao.OrderDao;
import com.yang.dao.ReturnInforDao;
import com.yang.model.Order_infor;
import com.yang.model.Return_order_infor;
import com.yang.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.text.SimpleDateFormat;
import java.util.List;

public class ReturnInforService {
    public static Object[][] showReturnInfor(){
        Object[][] objects=null;
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        ReturnInforDao returnInforDao =sqlSession.getMapper(ReturnInforDao.class);
        List<Return_order_infor> returnOrderInfors =returnInforDao.selectAllReturns();

        SimpleDateFormat sdf =new SimpleDateFormat("yyy-MM-dd HH:mm");
        if (returnOrderInfors.size()!=0){
            objects =new Object[returnOrderInfors.size()][];
            for (int i = 0; i < returnOrderInfors.size(); i++) {
                objects[i] = new Object[]{
                        returnOrderInfors.get(i).getOid(),
                        returnOrderInfors.get(i).getUname(),
                        returnOrderInfors.get(i).getFname(),
                        returnOrderInfors.get(i).getSname(),
                        sdf.format(returnOrderInfors.get(i).getStime()),
                        sdf.format(returnOrderInfors.get(i).getWtime())
                };
            }
        }
sqlSession.close();
        return objects;
    }

}
