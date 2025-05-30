package com.example.springjwt.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LoginReq {
    private String firstName;
    private String lastName;
    private String email;
    private String password;


    public LoginReq(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
