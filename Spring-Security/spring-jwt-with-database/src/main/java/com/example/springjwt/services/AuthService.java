package com.example.springjwt.services;

import com.example.springjwt.entity.Token;
import com.example.springjwt.entity.TokenType;
import com.example.springjwt.entity.User;
import com.example.springjwt.model.request.AuthenticationResponse;
import com.example.springjwt.model.request.LoginRequest;
import com.example.springjwt.model.request.RegisterRequest;
import com.example.springjwt.repositories.TokenRepository;
import com.example.springjwt.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthService
{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private TokenRepository tokenRepository;

    @Autowired
    private  AuthenticationManager authenticationManager;

    public AuthenticationResponse login(LoginRequest request)
    {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(),request.getPassword()));
        User user = userRepository.findUserByEmail(request.getEmail());
        Map<String , Object> extraClaims = new HashMap<>();
        String jwtToken = jwtService.createToken(user , extraClaims);
        saveUserToken(user, jwtToken);
        return new AuthenticationResponse(jwtToken , request.getEmail());
    }

    public AuthenticationResponse register(RegisterRequest request)
    {
        User user = User.builder()
                .firstName(request.getFirstname())
                .lastName(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(request.getRole())
                .build();

        User savedUser = userRepository.save(user);
        Map<String , Object> extraClaims = new HashMap<>();
        String jwtToken = jwtService.createToken(user , extraClaims);
        saveUserToken(savedUser, jwtToken);
        return new AuthenticationResponse(jwtToken , request.getEmail());
    }

    private void saveUserToken(User user, String jwtToken) {
        Token token = Token.builder()
                .user(user)
                .token(jwtToken)
                .tokenType(TokenType.BEARER)
                .expired(false)
                .revoked(false)
                .build();
        tokenRepository.save(token);
    }
}
