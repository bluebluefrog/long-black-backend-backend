package com.knowonespace.longblack.service.impl;

import com.knowonespace.longblack.exception.LongBlackExceptionEnum;
import com.knowonespace.longblack.exception.LongblackException;
import com.knowonespace.longblack.model.dao.AdminMapper;
import com.knowonespace.longblack.model.pojo.Admin;
import com.knowonespace.longblack.service.AdminService;
import com.knowonespace.longblack.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    public Admin adminLogin(String adminName, String password)throws LongblackException{
        String md5pass = null;
        try {
            md5pass = MD5Utils.getMD5Str(password);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        Admin admin = adminMapper.selectByAdminName(adminName);
        if (admin == null) {
            throw new LongblackException(LongBlackExceptionEnum.USER_NOT_EXISTED);
        }
        if(!md5pass.equals(admin.getPassword())){
            throw new LongblackException(LongBlackExceptionEnum.WRONG_PASSWORD);
        }
        return admin;
    }
}
