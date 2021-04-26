package com.knowonespace.longblack;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.knowonespace.longblack.model.dao")
public class LongBlackApplication {

    public static void main(String[] args) {
        SpringApplication.run(LongBlackApplication.class, args);
    }

}
