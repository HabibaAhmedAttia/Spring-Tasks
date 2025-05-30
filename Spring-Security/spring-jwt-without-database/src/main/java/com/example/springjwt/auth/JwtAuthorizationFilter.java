package com.example.springjwt.auth;

import com.example.springjwt.services.JwtService;
import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtAuthorizationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtService jwtService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        try {
            String accessToken = jwtService.resolveToken(request);

            if (accessToken == null ) {
                filterChain.doFilter(request, response);
                return;
            }

            System.out.println("token : "+accessToken);

            Claims claims = jwtService.resolveClaims(request);

            if(claims != null & !jwtService.isTokenExpired(claims.getExpiration())){

                String email = claims.getSubject();

                System.out.println("email : "+email);

                Authentication authentication = new UsernamePasswordAuthenticationToken(email,"",new ArrayList<>());

                SecurityContextHolder.getContext().setAuthentication(authentication);
            }

        }catch (Exception e){
            e.printStackTrace();

        }
        filterChain.doFilter(request, response);
    }
}
