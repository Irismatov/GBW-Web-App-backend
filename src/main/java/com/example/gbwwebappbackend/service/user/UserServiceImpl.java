package com.example.gbwwebappbackend.service.user;

import com.example.gbwwebappbackend.domain.request.RegisterRequestDto;
import com.example.gbwwebappbackend.entity.User;
import com.example.gbwwebappbackend.enums.UserRole;
import com.example.gbwwebappbackend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User save(RegisterRequestDto dto) {
        User user = new User();
        user.setUsername(dto.getUsername());
        String encodedPassword = passwordEncoder.encode(dto.getPassword());
        user.setPassword(encodedPassword);
        user.setRole(UserRole.ADMIN);
       return userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Username " + username + " not found"));
        return user;
    }
}
