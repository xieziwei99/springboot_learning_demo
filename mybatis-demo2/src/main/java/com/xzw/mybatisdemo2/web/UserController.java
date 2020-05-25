package com.xzw.mybatisdemo2.web;

import com.xzw.mybatisdemo2.mapper.UserMapper;
import com.xzw.mybatisdemo2.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author xieziwei99
 * 2020-01-18
 */
@RestController
public class UserController {
    private final UserMapper userMapper;

    @Autowired
    public UserController(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userMapper.selectList(null);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userMapper.selectById(id);
    }
}
