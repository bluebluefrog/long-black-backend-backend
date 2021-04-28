package com.knowonespace.longblack.config;

import com.knowonespace.longblack.filter.AdminFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

@Configuration
public class AdminFilterConfig {

    @Bean
    public AdminFilter adminFilter() {//定义Filter，增加Bean注解让Spring识别
        return new AdminFilter();
    }

    //把Filter放入整个链路之中
    @Bean(name ="adminFilterConf")
    public FilterRegistrationBean adminFilterConfig() {
        FilterRegistrationBean<Filter> filterFilterRegistrationBean = new FilterRegistrationBean<>();
        filterFilterRegistrationBean.setFilter(adminFilter());//注册上该Filter
        filterFilterRegistrationBean.addUrlPatterns("/admin/needFilter/");//过滤哪些url
        filterFilterRegistrationBean.setName("adminFilterConf");//增加名字
        return filterFilterRegistrationBean;
    }
}
