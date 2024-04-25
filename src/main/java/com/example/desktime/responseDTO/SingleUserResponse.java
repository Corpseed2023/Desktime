package com.example.desktime.responseDTO;

import com.example.desktime.model.Roles;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;
import java.util.Set;


@Getter
@Setter
public class SingleUserResponse {

    private Long id;
    private String username;
    private String email;
    private Long createdBy;
    private boolean isEnable;
    private Set<Roles> roles;


}
