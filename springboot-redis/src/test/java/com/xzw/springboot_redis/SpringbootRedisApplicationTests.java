package com.xzw.springboot_redis;

import com.xzw.springboot_redis.dao.UserRepository;
import com.xzw.springboot_redis.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootRedisApplicationTests {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CacheManager cacheManager;

    @Test
    public void test1() {
        User user = userRepository.findByName("u10");
        System.out.println("第一次查询：" + user.getAge());

        User user2 = userRepository.findByName("u10");
        System.out.println("第二次查询：" + user2.getAge());

        user.setAge(10);
        userRepository.save(user);
        User user3 = userRepository.findByName("u10");
        System.out.println("第三次查询：" + user3.getAge());
    }

}
