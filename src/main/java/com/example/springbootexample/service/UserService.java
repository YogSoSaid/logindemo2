package com.example.springbootexample.service;

import com.example.springbootexample.domain.User;

public interface UserService {
    User loginService(String uname, String password);
    User registService(User user);
}
