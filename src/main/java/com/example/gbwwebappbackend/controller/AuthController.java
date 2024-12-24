package com.example.gbwwebappbackend.controller;


import com.example.gbwwebappbackend.domain.request.LoginRequestDto;
import com.example.gbwwebappbackend.domain.request.RegisterRequestDto;
import com.example.gbwwebappbackend.service.auth.AuthService;
import com.example.gbwwebappbackend.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    private final AuthService authService;

    @PostMapping("/register")
    public Object register(@RequestBody RegisterRequestDto dto) {
        return userService.save(dto);
    }

    @PostMapping("/login")
    public Object login(@RequestBody LoginRequestDto dto) {
        return authService.login(dto);
    }

}
