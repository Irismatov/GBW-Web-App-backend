package com.example.gbwwebappbackend.service.newsletter;

import org.springframework.stereotype.Service;

@Service
public interface NewsLetterService {

    void save(String email);

}
