package com.dailycode.user.Controller;

import com.dailycode.user.Entity.User;
import com.dailycode.user.Service.UserService;
import com.dailycode.user.VO.ResponseTemplateVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user) {
        log.info("Inside the saveUser method of UserController");
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long userId) {
        log.info("Inside the getUserWithDepartment method of UserController");
        return userService.getUserWithDepartment(userId);
    }
}
