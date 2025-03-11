package com.user.UserServiceCapstone2025.service;

import com.user.UserServiceCapstone2025.models.Token;
import com.user.UserServiceCapstone2025.models.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User signUp(String name, String email, String password);
    Token login(String name, String password);
    void logout(String tokenValue);
    User validateToken(String tokenValue);
}
