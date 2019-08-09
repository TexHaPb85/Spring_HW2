package edu.practice.spring_hw2.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.practice.spring_hw2.entities.User;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;

@Service
public class UserService {

    public User returnNewUserByEmail(String email) {
        User user = new User("Alex", "Fax", LocalDate.now(), null, email, new HashMap<>());
        user.getDoneHomework().put("HW1", true);
        user.getDoneHomework().put("HW2", false);
        return user;
    }

    public User handleUser(User user) {
        //user.setAccessId(UUID.fromString("UUIDName").toString());
        user.setAccessId("random access id");
        serializeUser(user);
        return user;
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
