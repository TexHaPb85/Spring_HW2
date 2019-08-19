package edu.practice.hw12.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.practice.hw12.entities.HttpResponse;
import edu.practice.hw12.entities.UserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.junit.Assert;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;

@Service
public class UserService {

    public UserDTO createNewUserByEmail(String email) {
        UserDTO userDTO = new UserDTO("Alex", "Fax", LocalDate.now(), null, email, new HashMap<>());
        userDTO.getDoneHomework().put("HW1", true);
        userDTO.getDoneHomework().put("HW2", false);
        return userDTO;
    }

    public String setAccessIdAndSerialize(UserDTO userDTO){
        //userDTO.setAccessId(UUID.fromString("UUIDName").toString());
        HttpResponse httpResponse = new HttpResponse(HttpStatus.OK,"success");
        try {
            userDTO.setAccessId("random access id");
            serializeUser(userDTO);
            return String.valueOf(httpResponse.getHttpStatus());
        } catch (FileNotFoundException e) {
            httpResponse.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            httpResponse.setMassege("File not found");
            Assert.fail("IO Exception. Something is wrong.");
            return httpResponse.getMassege();
        } catch (IOException e) {
            httpResponse.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            httpResponse.setMassege("something went wrong");
            Assert.fail("IO Exception. Something is wrong.");
            return httpResponse.getMassege();
        }
    }



    public void serializeUser(UserDTO userDTO) throws FileNotFoundException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new FileOutputStream("target/task1.json"), userDTO);
    }
}
