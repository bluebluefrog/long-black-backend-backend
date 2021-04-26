package com.knowonespace.longblack.service;

import com.knowonespace.longblack.LongBlackApplicationTests;
import com.knowonespace.longblack.model.pojo.Admin;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.security.NoSuchAlgorithmException;

public class AdminServiceTest extends LongBlackApplicationTests {

    @Autowired
    AdminService adminService;

    @Test
    public void testLogin() throws NoSuchAlgorithmException {
        Admin wjb2 = adminService.adminLogin("wjb2", "12345678");
        System.out.println(wjb2.getAdminName());
    }
}
