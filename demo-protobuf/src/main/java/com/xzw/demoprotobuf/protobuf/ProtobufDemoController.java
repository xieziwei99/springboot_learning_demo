package com.xzw.demoprotobuf.protobuf;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xzw.demoprotobuf.protobuf.MessageUser.MessageUserLogin;
import com.xzw.demoprotobuf.protobuf.MessageUser.MessageUserLogin.Builder;

/**
 * @author xieziwei <xieziwei@kuaishou.com>
 * Created on 2021-06-28
 */
@RestController
@RequestMapping("/protobuf/demo")
public class ProtobufDemoController {

    @GetMapping(produces = "application/x-protobuf")
    public ResponseEntity<MessageUserLogin> getProto() {
        final Builder builder = MessageUserLogin.newBuilder();
        builder.setAccessToken("qwerty");
        builder.setUsername("Jack");
        return ResponseEntity.ok(builder.build());
    }
}
