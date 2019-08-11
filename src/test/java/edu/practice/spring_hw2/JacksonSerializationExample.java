package edu.practice.spring_hw2;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.practice.spring_hw2.entities.UserDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest
public class JacksonSerializationExample {

    public final String FILE_PATH = "target/output.json";
    public ObjectMapper objectMapper = new ObjectMapper();
    private UserDTO transferUser = new UserDTO("Jamie", "Lanoster", LocalDate.now().minusDays(1), "ac1234", "userJamie@gmail.com", new HashMap<String, Boolean>());

    @Test
    public void serializationExample() {
        UserDTO userDTO = transferUser;

        try {
            objectMapper.writeValue(new FileOutputStream(FILE_PATH), userDTO);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void deserializationExample() {
        UserDTO userDTO = null;
        try {
            userDTO = objectMapper.readValue(new FileInputStream(FILE_PATH), UserDTO.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        assertEquals(transferUser.getName(), userDTO.getName());
        assertEquals(transferUser.getSurName(), userDTO.getSurName());
        assertEquals(transferUser.getEmail(), userDTO.getEmail());
        assertEquals(transferUser.getLastLoginDate(), userDTO.getLastLoginDate());
        assertEquals(transferUser.getDoneHomework(), userDTO.getDoneHomework());

        assertEquals(null, userDTO.getAccessId());


    }

}
