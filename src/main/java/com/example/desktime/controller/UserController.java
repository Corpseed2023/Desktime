package com.example.desktime.controller;


import com.example.desktime.model.User;
import com.example.desktime.requestDTO.UserRequest;
import com.example.desktime.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;


@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/createUser")
    public ResponseEntity<String> postData(@RequestBody UserRequest userRequest) {
        try {
            userService.saveUserData(userRequest);
            return new ResponseEntity<>("User created successfully!", HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>("Invalid user data: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>("One or more roles not found", HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("Error processing the request", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/userDetails")
    public ResponseEntity<User> getUserDetails(@RequestParam String username) {
        User user = new User();
        user.setUsername(username);
//        user.setEmail(email);

        ResponseEntity<User> responseEntity = userService.getUserdetails(user);

        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            return responseEntity;
        } else {

            return ResponseEntity.notFound().build();
        }
    }

}
