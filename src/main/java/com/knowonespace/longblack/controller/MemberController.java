package com.knowonespace.longblack.controller;

import com.knowonespace.longblack.Common.ApiRestResponse;
import com.knowonespace.longblack.exception.LongBlackExceptionEnum;
import com.knowonespace.longblack.model.pojo.Member;
import com.knowonespace.longblack.service.MemberService;
import com.mysql.cj.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping("/register")
    public ApiRestResponse register(@RequestParam("userName") String userName, @RequestParam("password") String password) {
        if (StringUtils.isNullOrEmpty(userName)) {//检查传递进来的只是否为空
            return ApiRestResponse.error(LongBlackExceptionEnum.NEED_USER_NAME);//这里用户名为空的话返回错误
        }
        if (StringUtils.isNullOrEmpty(password)) {//检查传递进来的只是否为空
            return ApiRestResponse.error(LongBlackExceptionEnum.NEED_PASSWORD);//这里密码为空的话返回错误
        }

        //密码长度小于8位报错
        if (password.length() < 8) {
            return ApiRestResponse.error(LongBlackExceptionEnum.PASSWORD_TOO_SHORT);
        }
        memberService.register(userName,password);

        return ApiRestResponse.success();
    }

    @PostMapping("/login")
    public ApiRestResponse login(@RequestParam("userName") String userName, @RequestParam("password") String password, HttpSession session) {

        if (StringUtils.isNullOrEmpty(userName)) {//检查传递进来的只是否为空
            return ApiRestResponse.error(LongBlackExceptionEnum.NEED_USER_NAME);//这里用户名为空的话返回错误
        }
        if (StringUtils.isNullOrEmpty(password)) {//检查传递进来的只是否为空
            return ApiRestResponse.error(LongBlackExceptionEnum.NEED_PASSWORD);//这里密码为空的话返回错误
        }

        //密码长度小于8位报错
        if (password.length() < 8) {
            return ApiRestResponse.error(LongBlackExceptionEnum.PASSWORD_TOO_SHORT);
        }
        Member member = memberService.login(userName, password);
        session.setAttribute("cur_member", member);
        member.setPassword(null);

        return ApiRestResponse.success(member);
    }

    @PostMapping("/logout")
    public ApiRestResponse logout(HttpSession session) {
        session.removeAttribute("cur_member");

        return ApiRestResponse.success();
    }
}
