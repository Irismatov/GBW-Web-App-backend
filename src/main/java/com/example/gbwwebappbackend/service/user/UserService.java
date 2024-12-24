package com.example.gbwwebappbackend.service.user;

import com.example.gbwwebappbackend.domain.request.RegisterRequestDto;
import com.example.gbwwebappbackend.entity.User;

public interface UserService {
    User save(RegisterRequestDto dto);
    User findByUsername(String username);
}
