package com.example.gbwwebappbackend.service.auth;

import com.example.gbwwebappbackend.domain.request.LoginRequestDto;
import com.example.gbwwebappbackend.domain.request.RegisterRequestDto;
import com.example.gbwwebappbackend.domain.response.JwtResponseDto;
import com.example.gbwwebappbackend.entity.User;
import com.example.gbwwebappbackend.service.user.UserService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserService userService;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    @Value("${admin.password}")
    private String adminPassword;
    @Value("${admin.username}")
    private String adminUsername;

    @PostConstruct
    public void init() {
        try {
            userService.findByUsername(adminUsername);
        } catch (UsernameNotFoundException e) {
            userService.save(new RegisterRequestDto(adminUsername, adminPassword));
        }
    }

    public JwtResponseDto login(LoginRequestDto loginDto) {
        User user = userService.findByUsername(loginDto.getUsername());
        if(passwordEncoder.matches(loginDto.getPassword(), user.getPassword())) {
            return new JwtResponseDto(jwtService.generateToken(user));
        }
        throw new UsernameNotFoundException("Wrong password");
    }
}
