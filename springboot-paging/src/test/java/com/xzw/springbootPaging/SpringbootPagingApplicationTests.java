package com.xzw.springbootPaging;

import com.xzw.springbootPaging.entity.User;
import com.xzw.springbootPaging.entity.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootPagingApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void contextLoads() {
        List<User> users = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            User user = new User();
            user.setName("name" + i);
            user.setAge(i);
            user.setBirthday("birthday" + i);
            users.add(user);
        }
        userRepository.saveAll(users);
    }

}
