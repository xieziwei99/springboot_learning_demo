package com.xzw.springboot_learning_demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @RequestMapping("/hello")
    public String sayHello(ModelMap map) {
        map.addAttribute("name", "Hello Jack Xie");
        return "hello";
    }

    @RequestMapping("/helloError")
    @ResponseBody
    public String sayHi() throws Exception {
        throw new Exception("发生错误");
    }

    @RequestMapping("/jsonError")
    public String jsonError() {
        int a =  5 / 0;
        return a + "";
    }
}
