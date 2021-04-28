package com.knowonespace.longblack.filter;

import com.knowonespace.longblack.model.pojo.Admin;
import com.knowonespace.longblack.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class AdminFilter implements Filter {

    @Autowired
    AdminService adminService;//需要用到UserService

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //初始化不需要动作
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //拿到Session
        //转换成Httprequest
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession();
        Admin currentAdmin =(Admin) session.getAttribute("cur_admin");
        //查看是否存在用户
        if (currentAdmin == null) {
           //为了给提示需要用到输出流
            //因为这里的返回是固定的void
            //先拿到Writer
            PrintWriter out = new HttpServletResponseWrapper((HttpServletResponse) servletResponse).getWriter();
            out.write("{\n" +
                    "    \"status\": 10007,\n" +
                    "    \"msg\": \"NEED_LOGIN\",\n" +
                    "    \"data\": null\n" +
                    "}");
            out.flush();//输出
            out.close();//关闭
            return;//还没有进入controller之前就return方法，结束调用
        }
         //是管理员放行
            filterChain.doFilter(servletRequest, servletResponse);
        }

    @Override
    public void destroy() {
        //摧毁不需要动作
    }
}
