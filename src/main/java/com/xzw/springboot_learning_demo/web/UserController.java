package com.xzw.springboot_learning_demo.web;

import com.xzw.springboot_learning_demo.pojo.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController     // 不需要配置@ResponseBody、默认返回json格式
@RequestMapping(value = "/users")   // 是下面的配置都映射在/users下
public class UserController {

    // 创建线程安全的Map
    private static Map<Long, User> users = Collections.synchronizedMap(new HashMap<>());

    @ApiOperation(value = "获取用户列表")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<User> getUserList() {
        return new ArrayList<>(users.values());
    }

    @ApiOperation(value = "创建用户", notes = "根据User对象创建用户")
    @ApiImplicitParam(name = "user", value = "用户详细实体User", required = true, dataType = "User")
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String postUser(@ModelAttribute User user) {
        users.put(user.getId(), user);
        return "success";
    }

    @ApiOperation(value = "根据id获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "Long")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable Long id) {
        // 通过@PathVariable把url中的id绑定到函数的参数中
        return users.get(id);
    }

    @ApiOperation(value = "更新用户信息", notes = "根据url中的id指定更新对象，根据传入的User对象更新信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "user id", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String putUser(@PathVariable Long id, @ModelAttribute User user) {
        User u = users.get(id);
        u.setName(user.getName());
        u.setAge(user.getAge());
        users.put(id, u);
        return "success";
    }

    @ApiOperation(value = "根据id删除用户")
    @ApiImplicitParam(name = "id", value = "user id", required = true, dataType = "Long")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable Long id) {
        users.remove(id);
        return "success";
    }
}
