package com.example.desktime.responseDTO;

import lombok.Getter;
import lombok.Setter;
import java.util.Set;

@Getter
@Setter
public class LoginResponse {
    private String message;
    private Long id;
    private String username;
    private String email;
    private Set<String> roles; // Change to Set of String for role names

    public LoginResponse(String message) {
        this.message = message;
    }


}