package edu.practice.spring_hw2.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.practice.spring_hw2.entities.UserDTO;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;

@Service
public class UserService {

    public UserDTO returnNewUserByEmail(String email) {
        UserDTO userDTO = new UserDTO("Alex", "Fax", LocalDate.now(), null, email, new HashMap<>());
        userDTO.getDoneHomework().put("HW1", true);
        userDTO.getDoneHomework().put("HW2", false);
        return userDTO;
    }

    public UserDTO handleUser(UserDTO userDTO) throws IOException {
        //userDTO.setAccessId(UUID.fromString("UUIDName").toString());
        userDTO.setAccessId("random access id");
        serializeUser(userDTO);
        return userDTO;
    }

    public void serializeUser(UserDTO userDTO) throws FileNotFoundException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new FileOutputStream("target/task1.json"), userDTO);
    }
}
