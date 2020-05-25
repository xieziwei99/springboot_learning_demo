package com.xzw.mybatisdemo2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xzw.mybatisdemo2.mapper")
public class MybatisDemo2Application {

    public static void main(String[] args) {
        SpringApplication.run(MybatisDemo2Application.class, args);
    }

}
