package com.yang.service;

public interface LoginService {
    boolean adminLogin(String name,String password);
    boolean updateAdmin(String name,String password);
}
