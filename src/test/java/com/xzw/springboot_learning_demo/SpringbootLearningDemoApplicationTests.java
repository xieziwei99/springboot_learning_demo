package com.xzw.springboot_learning_demo;

import com.xzw.springboot_learning_demo.pojo.BlogProperties;
import com.xzw.springboot_learning_demo.web.HelloController;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootLearningDemoApplicationTests {

    @Autowired
    BlogProperties blogProperties;

    @Test
    public void testSayHello() {
        assertEquals("Hello World!", new HelloController().sayHello());
    }

    @Test
    public void testBlogProperties() {
        Assert.assertEquals(blogProperties.getName(), "xzw");
        Assert.assertEquals(blogProperties.getDate(), "20190407");
        Assert.assertEquals(blogProperties.getBlog(), "Blog is created by xzw on 20190407");
    }
}
