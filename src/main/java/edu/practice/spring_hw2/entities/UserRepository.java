package edu.practice.spring_hw2.entities;


import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.UUID;

@Repository
public class UserRepository {
    private User userForTesting;

    public UserRepository() {
        userForTesting = new User("Alex",
                "Fax",
                LocalDate.now().minusDays(1),
                UUID.randomUUID().toString(),
                "testUserEmail.@gmail.com",
                new HashMap<>());
        userForTesting.getDoneHomework().put("HW1",true);
        userForTesting.getDoneHomework().put("HW2",false);
    }
}
