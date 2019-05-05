package com.xzw.springbootthymeleaf.web;

import com.xzw.springbootthymeleaf.pojo.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("name", "thymeleaf");
        return "hello";
    }

    @RequestMapping("/test")
    public String test(Model model) {
        String content = "<p style='color:red'> 红色文字</p>";
        Product product = new Product(1, "p1", 100.0);
        Date date = new Date();
        model.addAttribute("content", content);
        model.addAttribute("product", product);
        model.addAttribute("boo", true);
        model.addAttribute("date", date);
        return "test";
    }
}
