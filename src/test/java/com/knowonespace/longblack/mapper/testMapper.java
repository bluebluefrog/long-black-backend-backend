package com.knowonespace.longblack.mapper;

import com.knowonespace.longblack.LongBlackApplicationTests;
import com.knowonespace.longblack.model.dao.AdminMapper;
import com.knowonespace.longblack.model.pojo.Admin;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class testMapper extends LongBlackApplicationTests {

    @Autowired
    private AdminMapper adminMapper;

    @Test
    public void testSelectByPrimaryKey(){
        System.out.println(adminMapper.selectByPrimaryKey(11l));
    }

    @Test
    public void insertSelective(){
        Admin user = new Admin();
        user.setPassword("123456");
        user.setAdminName("wjb2");
        adminMapper.insertSelective(user);
    }

    @Test
    public void deleteByPrimaryKey(){
        System.out.println(adminMapper.deleteByPrimaryKey(11l));
    }

    @Test
    public void selectByName() {
        Admin wjb2 = adminMapper.selectByAdminName("wjb2");
        System.out.println(wjb2.getAdminName());
    }
}
