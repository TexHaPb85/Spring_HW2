package edu.practice.hw12.controller;

import edu.practice.hw12.entities.UserDTO;
import edu.practice.hw12.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("{email}")
    public UserDTO getNewUser(@PathVariable String email) {
        return userService.createNewUserByEmail(email);
    }

    @PostMapping
    public String handleUser(@RequestBody UserDTO userDTO) {
        return userService.setAccessIdAndSerialize(userDTO);
    }
}
