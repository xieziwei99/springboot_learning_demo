package com.xzw.springdatajpaehcache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringDataJpaEhcacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaEhcacheApplication.class, args);
    }

}
