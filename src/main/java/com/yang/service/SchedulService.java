package com.yang.service;

import com.yang.model.Schedul;

public interface SchedulService {
    Object[][] showFilmInfor();
    Boolean  buyTicket(String name,String phone,int fid);
    String[] showSid();
    boolean addSchedul(Schedul schedul);
    boolean delSchedul(int sid);
    Object[][] findSheduls(String sname);
}
