package com.devchoi0926.todaysworkoutserver.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpDto {

    private String username;

    private String password;

    private String role;
}
