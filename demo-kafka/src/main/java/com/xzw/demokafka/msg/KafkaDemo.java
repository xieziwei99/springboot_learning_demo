package com.xzw.demokafka.msg;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * kafka 使用示例，需要本地安装并启动 kafka，使用 SpringBoot 无需其他配置
 * @author xieziwei <xieziwei@kuaishou.com>
 * Created on 2021-07-08
 */
@Component
@EnableScheduling
@Slf4j
public class KafkaDemo {

    private KafkaTemplate<String, String> kafkaTemplate;

    public KafkaDemo(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public static final String QUICKSTART_EVENT = "quickstart-events";

    @Bean
    public NewTopic topic() {
        return TopicBuilder.name(QUICKSTART_EVENT).build();
    }

    // 表示每 3 秒执行一次
    @Scheduled(cron = "*/3 * * * * ?")
    public void producer() {
        kafkaTemplate.send(QUICKSTART_EVENT, String.valueOf(System.currentTimeMillis()));
    }

    @KafkaListener(id = "listener1", topics = QUICKSTART_EVENT)
    public void listener(String in) {
        log.info(in);
    }
}
