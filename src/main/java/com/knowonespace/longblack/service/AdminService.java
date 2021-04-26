package com.knowonespace.longblack.service;

import com.knowonespace.longblack.model.pojo.Admin;

public interface AdminService{

    Admin adminLogin(String adminName,String password);
}
