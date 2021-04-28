package com.knowonespace.longblack.controller.admin;

import com.knowonespace.longblack.Common.ApiRestResponse;
import com.knowonespace.longblack.exception.LongBlackExceptionEnum;
import com.knowonespace.longblack.exception.LongblackException;
import com.knowonespace.longblack.model.pojo.Admin;
import com.knowonespace.longblack.service.AdminService;
import com.mysql.cj.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/login")
    public ApiRestResponse adminLogin(String adminName, String password, HttpSession session){
        if (StringUtils.isNullOrEmpty(adminName)) {
            return ApiRestResponse.error(LongBlackExceptionEnum.NEED_USER_NAME);
        }
        if (StringUtils.isNullOrEmpty(password)) {
            return ApiRestResponse.error(LongBlackExceptionEnum.NEED_PASSWORD);
        }
        //密码长度小于8位报错
        if (password.length() < 8) {
            return ApiRestResponse.error(LongBlackExceptionEnum.PASSWORD_TOO_SHORT);
        }

        Admin admin = null;
        admin = adminService.adminLogin(adminName, password);

        admin.setPassword(null);

        session.setAttribute("cur_admin", admin);

        return ApiRestResponse.success(admin);
    }

    @PostMapping("/logout")
    public ApiRestResponse adminLogout(HttpSession session){
        session.removeAttribute("cur_admin");

        return ApiRestResponse.success();
    }
}
