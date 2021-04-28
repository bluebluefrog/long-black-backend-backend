package com.knowonespace.longblack.config;

import com.knowonespace.longblack.filter.UserFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

@Configuration
public class UserFilterConfig {

    @Bean
    public UserFilter userFilter() {//定义Filter，增加Bean注解让Spring识别
        return new UserFilter();
    }

    //把Filter放入整个链路之中
    @Bean(name ="userFilterConf")
    public FilterRegistrationBean userFilterConfig() {
        FilterRegistrationBean<Filter> filterFilterRegistrationBean = new FilterRegistrationBean<>();
        filterFilterRegistrationBean.setFilter(userFilter());//注册上该Filter
        filterFilterRegistrationBean.addUrlPatterns("/member/evaluate");//过滤哪些url
        filterFilterRegistrationBean.setName("userFilterConf");//增加名字
        return filterFilterRegistrationBean;
    }
}
