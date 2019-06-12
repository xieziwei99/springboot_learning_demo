package com.xzw.springboot_learning_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringbootLearningDemoApplication {

    public static void main(String[] args) {
        // 屏蔽命令行访问属性
        new SpringApplication(SpringbootLearningDemoApplication.class).setAddCommandLineProperties(false);
        // 主程序运行
        SpringApplication.run(SpringbootLearningDemoApplication.class, args);
        }

        }
