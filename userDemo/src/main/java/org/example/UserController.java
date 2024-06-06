package org.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/user/{name}")
    public User getUserByName(@PathVariable String name) {
        // 这里只是一个示例，实际情况下，你需要从数据库或其他数据源获取用户信息
        User user = new User();
        user.setName(name);
        user.setEmail(name + "@example.com");
        user.setPhoneNumber("123-456-7890");
        return user;
    }
}
