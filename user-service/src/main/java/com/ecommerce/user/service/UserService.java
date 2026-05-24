package com.ecommerce.user.service;

import com.ecommerce.user.dto.AuthRequest;
import com.ecommerce.user.entity.User;
import com.ecommerce.user.repository.UserRepository;
import com.ecommerce.user.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    private BCryptPasswordEncoder encoder =
            new BCryptPasswordEncoder();

    public User register(User user){

        user.setPassword(
                encoder.encode(user.getPassword())
        );

        return userRepository.save(user);
    }

    public String login(AuthRequest request){

        User user =
                userRepository.findByEmail(request.getEmail())
                        .orElseThrow(
                                () -> new RuntimeException("User not found")
                        );

        boolean match =
                encoder.matches(
                        request.getPassword(),
                        user.getPassword()
                );

        if(!match){
            throw new RuntimeException("Invalid Password");
        }

        return jwtUtil.generateToken(user.getEmail());
    }
}