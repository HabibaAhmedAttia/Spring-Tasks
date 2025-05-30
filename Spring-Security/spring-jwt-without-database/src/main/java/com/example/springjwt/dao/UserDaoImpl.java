package com.example.springjwt.dao;

import com.example.springjwt.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao
{
    public User findUserByEmail(String email)
    {
        //check for user by email in the database
        User user = new User(email,"123456");
        user.setFirstName("ahmed");
        user.setLastName("salah");
        return user;
    }
}
