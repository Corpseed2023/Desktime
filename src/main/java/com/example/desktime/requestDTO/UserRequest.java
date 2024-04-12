package com.example.desktime.requestDTO;


import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Comment;

import java.util.Date;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
public class UserRequest {

    private String username;
    private String email;
    private String password;
    private Long createdBy;
    private Date createdAt;
    private Date updatedAt;
    private boolean isEnable;
    private Set<String> roleNames; // Field to store role names

}