package edu.practice.spring_hw2;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.practice.spring_hw2.entities.User;
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
    private User transferUser = new User("Jamie", "Lanoster", LocalDate.now().minusDays(1), "ac1234", "userJamie@gmail.com", new HashMap<String, Boolean>());

    @Test
    public void serializationExample() {
        User user = transferUser;

        try {
            objectMapper.writeValue(new FileOutputStream(FILE_PATH), user);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void deserializationExample() {
        User user = null;
        try {
            user = objectMapper.readValue(new FileInputStream(FILE_PATH), User.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        assertEquals(transferUser.getName(), user.getName());
        assertEquals(transferUser.getSurName(), user.getSurName());
        assertEquals(transferUser.getEmail(), user.getEmail());
        assertEquals(transferUser.getLastLoginDate(), user.getLastLoginDate());
        assertEquals(transferUser.getDoneHomework(), user.getDoneHomework());

        assertEquals(null,user.getAccessId());


    }

}
