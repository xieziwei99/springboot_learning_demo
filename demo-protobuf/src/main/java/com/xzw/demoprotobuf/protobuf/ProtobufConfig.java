package com.xzw.demoprotobuf.protobuf;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

/**
 * @author xieziwei <xieziwei@kuaishou.com>
 * Created on 2021-06-28
 */
@Configuration
public class ProtobufConfig {

    // 序列化
    @Bean
    ProtobufHttpMessageConverter protobufHttpMessageConverter() {
        return new ProtobufHttpMessageConverter();
    }

    // 反序列化
    @Bean
    RestTemplate restTemplate(ProtobufHttpMessageConverter protobufHttpMessageConverter) {
        return new RestTemplate(Collections.singletonList(protobufHttpMessageConverter));
    }
}
