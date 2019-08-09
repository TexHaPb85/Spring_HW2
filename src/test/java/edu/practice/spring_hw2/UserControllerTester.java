package edu.practice.spring_hw2;

import edu.practice.spring_hw2.entities.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTester {
    private User user = new User("Alex", "Fax", LocalDate.now(), null, "email@gmai.com", new HashMap<>());

    @Test
    public void testGetNewUser() {
        user.getDoneHomework().put("HW1",true);
        user.getDoneHomework().put("HW2",false);
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8081/user/email@gmai.com";

        ResponseEntity<User> userResponseEntity = restTemplate.getForEntity(url, User.class);
        assertEquals(HttpStatus.OK, userResponseEntity.getStatusCode());
        //assertEquals(user,userResponseEntity.getBody());
    }

    @Test
    public void testHandleUser() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8081/user";

        HttpEntity<User> requestHttpEntity = new HttpEntity<>(user);
        ResponseEntity<User> responseEntity = restTemplate.postForEntity(url, requestHttpEntity, User.class);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(user,responseEntity.getBody());
    }
}
