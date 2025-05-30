package com.example.springjwt.dao;

import com.example.springjwt.entity.User;

public interface UserDao
{
    User findUserByEmail(String email);
}
