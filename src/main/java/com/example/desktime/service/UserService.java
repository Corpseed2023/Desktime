package com.example.desktime.service;


import com.example.desktime.model.User;
import com.example.desktime.requestDTO.UserRequest;
import com.example.desktime.responseDTO.UserResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {


    ResponseEntity<User> getUserdetails(User user);
    User getUserByUsernameAndEmail(String username, String email);

    void saveUserData(UserRequest userRequest);

    List<UserResponse> getAllUsers();
}
