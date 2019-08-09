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
import java.util.UUID;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTester {


    @Test
    public void testGetNewUser() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8081/user/email@gmai.com";

        ResponseEntity<User> userResponseEntity = restTemplate.getForEntity(url, User.class);
        assertEquals(HttpStatus.OK, userResponseEntity.getStatusCode());
        //assertEquals(user,userResponseEntity.getBody());
    }

    @Test
    public void testHandleUser() {
        User requestingUser = new User("Alex", "Presly", LocalDate.now().minusDays(1), null, "email@gmai.com", new HashMap<>());
        requestingUser.getDoneHomework().put("HW1", true);
        requestingUser.getDoneHomework().put("HW2", false);

        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8081/user";

        HttpEntity<User> requestHttp = new HttpEntity<>(requestingUser);
        ResponseEntity<User> responseEntity = restTemplate.postForEntity(url, requestHttp, User.class);

        //requestingUser.setAccessId(UUID.fromString("UUIDName").toString());
        requestingUser.setAccessId("random access id");

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        assertEquals(requestingUser.getName(), responseEntity.getBody().getName());
        assertEquals(requestingUser.getSurName(), responseEntity.getBody().getSurName());
        assertEquals(requestingUser.getLastLoginDate(), responseEntity.getBody().getLastLoginDate());
        //assertEquals(requestingUser.getAccessId(), responseEntity.getBody().getAccessId());
        assertEquals(requestingUser.getDoneHomework(), responseEntity.getBody().getDoneHomework());
    }
}
