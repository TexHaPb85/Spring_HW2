package edu.practice.spring_hw2.controller;

import edu.practice.spring_hw2.entities.HandlingResponse;
import edu.practice.spring_hw2.entities.UserDTO;
import edu.practice.spring_hw2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.io.IOException;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("{email}")
    public UserDTO getNewUser(@PathVariable String email) {
        return userService.returnNewUserByEmail(email);
    }

    @PostMapping
    public String handleUser(@RequestBody UserDTO userDTO) {
        HandlingResponse handlingResponse = new HandlingResponse(HttpStatus.OK,"success");
        try {
            userService.handleUser(userDTO);
            return String.valueOf(handlingResponse.getHttpStatus());
        } catch (FileNotFoundException e) {
            handlingResponse.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            handlingResponse.setMassege("File not found");
            return handlingResponse.getMassege();
        } catch (IOException e) {
            handlingResponse.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            handlingResponse.setMassege("IOException");
            return handlingResponse.getMassege();
        }
    }
}
