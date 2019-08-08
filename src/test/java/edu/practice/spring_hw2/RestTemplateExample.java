package edu.practice.spring_hw2;

import edu.practice.spring_hw2.entities.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestTemplateExample {
    @Test
    public void testUserController() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8081/user/email@gmai.com";

        ResponseEntity<User> userResponseEntity = restTemplate.getForEntity(url, User.class);
        assertEquals(HttpStatus.OK, userResponseEntity.getStatusCode());
        //assertEquals(new User("Alex", "Fax", LocalDate.now(), null, "email@gmai.com", new HashMap<>()),userResponseEntity.getBody());
    }
}
