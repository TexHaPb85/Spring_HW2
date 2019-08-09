package edu.practice.spring_hw2.controller;

import edu.practice.spring_hw2.entities.User;
import edu.practice.spring_hw2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("{email}")
    public User getNewUser(@PathVariable String email) {
        return userService.returnNewUserByEmail(email);
    }

    @PostMapping
    public User handleUser(@RequestBody User user) {
        return userService.handleUser(user);
    }


}
