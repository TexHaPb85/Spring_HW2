package edu.practice.hw12;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.practice.hw12.entities.UserDTO;
import org.junit.Assert;
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
public class JacksonSerializationTest {

    public final String FILE_PATH = "target/output.json";
    public ObjectMapper objectMapper = new ObjectMapper();
    private UserDTO expectedUser = new UserDTO("Jamie", "Lanoster", LocalDate.now().minusDays(1), "ac1234", "userJamie@gmail.com", new HashMap<String, Boolean>());

    @Test
    public void serializationTest() {
        UserDTO testUser = expectedUser;

        try {
            objectMapper.writeValue(new FileOutputStream(FILE_PATH), testUser);
        } catch (IOException e) {
            Assert.fail("IO Exception. Something is wrong.");
            //e.printStackTrace();
        }
    }

    @Test
    public void deserializationTest() {
        UserDTO testUser = null;
        try {
            testUser = objectMapper.readValue(new FileInputStream(FILE_PATH), UserDTO.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        assertEquals(expectedUser.getName(), testUser.getName());
        assertEquals(expectedUser.getSurName(), testUser.getSurName());
        assertEquals(expectedUser.getEmail(), testUser.getEmail());
        assertEquals(expectedUser.getLastLoginDate(), testUser.getLastLoginDate());
        assertEquals(expectedUser.getDoneHomework(), testUser.getDoneHomework());

        assertEquals(null, testUser.getAccessId());


    }

}
