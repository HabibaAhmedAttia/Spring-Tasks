package com.example.springjwt.controllers;

import com.example.springjwt.entity.User;
import com.example.springjwt.model.request.LoginReq;
import com.example.springjwt.model.response.LoginRes;
import com.example.springjwt.services.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;
import java.util.Objects;

@Controller
@RequestMapping("/rest/auth")
public class AuthController {

    @Autowired
    private  AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @PostMapping(value = "/login")
    public ResponseEntity login(@RequestBody LoginReq loginRequest , @RequestParam Map<String , Object> claims)  {

        try {
            Authentication authentication =
                    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
            String email = authentication.getName();
            User user = new User(loginRequest.getFirstName() , loginRequest.getLastName() , loginRequest.getEmail() , "");
            String token = jwtService.createToken(user , claims);
            LoginRes loginRes = new LoginRes(email,token);

            return ResponseEntity.ok(loginRes);

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}