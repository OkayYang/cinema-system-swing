package com.yang.service.Impl;

import com.yang.dao.ReturnInforDao;
import com.yang.model.Return_order_infor;
import com.yang.service.ReturnInforService;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;
@Service("returnInforService")
public class ReturnInforServiceImpl implements ReturnInforService {
    @Autowired
    private ReturnInforDao returnInforDao;
    public Object[][] showReturnInfor(){
        Object[][] objects=null;
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
        return objects;
    }

    public  Object[][] findReturnInfor(String uname){
        Object[][] objects=null;
        List<Return_order_infor> returnOrderInfors =returnInforDao.findReturns(uname);

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
        return objects;
    }

}
