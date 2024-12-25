package com.example.gbwwebappbackend.controller;


import com.example.gbwwebappbackend.domain.request.LoginRequestDto;
import com.example.gbwwebappbackend.domain.request.RegisterRequestDto;
import com.example.gbwwebappbackend.service.auth.AuthService;
import com.example.gbwwebappbackend.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    private final AuthService authService;

/*

    @PostMapping("/register")
    public ResponseEntity<Object> register(@RequestBody RegisterRequestDto dto) {
        return ResponseEntity.ok(userService.save(dto));
    }
*/

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody LoginRequestDto dto) {
        return ResponseEntity.ok(authService.login(dto));
    }

    @GetMapping("/check-auth")
    public ResponseEntity<Object> validateAuthToken() {
        return ResponseEntity.ok().build();
    }

}
