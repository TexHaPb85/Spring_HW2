package edu.practice.spring_hw2.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.practice.spring_hw2.entities.User;
import org.springframework.web.bind.annotation.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;

@RestController
@RequestMapping("user")
public class UserController {

    @GetMapping("{email}")
    public User getUser(@PathVariable String email) {
        return new User("Alex", "Fax", LocalDate.now(), null, email, new HashMap<>());
    }

    @PostMapping
    public void handleUser(@RequestBody User user) {
        user.setAccessId("id:" + Math.random() * 999);
        serializeUser(user);
    }

    public void serializeUser(User user) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new FileOutputStream("target/task1.json"), user);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
