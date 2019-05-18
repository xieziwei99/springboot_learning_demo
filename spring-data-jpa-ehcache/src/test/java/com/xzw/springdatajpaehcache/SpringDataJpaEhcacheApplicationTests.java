package com.xzw.springdatajpaehcache;

import com.xzw.springdatajpaehcache.dao.UserRepository;
import com.xzw.springdatajpaehcache.pojo.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringDataJpaEhcacheApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void contextLoads() {
        for (int i = 1; i <= 10; i++) {
            userRepository.save(new User("u" + i, i));
        }

        Assert.assertEquals(10, userRepository.findAll().size());
        Assert.assertEquals(6, userRepository.findByName("u6").getAge().intValue());
        Assert.assertEquals(6,userRepository.findUser("u6").getAge().intValue());
        Assert.assertEquals("u6", userRepository.findByNameAndAge("u6", 6).getName());
    }

    @Test
    public void test1() {
        User user = userRepository.findByName("u10");
        System.out.println("第一次查询：" + user.getAge());

        User user2 = userRepository.findByName("u10");
        System.out.println("第二次查询：" + user2.getAge());
    }

}
