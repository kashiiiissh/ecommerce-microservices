package com.ecommerce.user.controller;

import com.ecommerce.user.dto.AuthRequest;
import com.ecommerce.user.dto.AuthResponse;
import com.ecommerce.user.entity.User;
import com.ecommerce.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User register(
            @RequestBody User user){

        return userService.register(user);
    }

    @PostMapping("/login")
    public AuthResponse login(
            @RequestBody AuthRequest request){

        String token =
                userService.login(request);

        return new AuthResponse(token);
    }
}