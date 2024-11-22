package com.example.gbwwebappbackend.service.vacancy;

import com.example.gbwwebappbackend.domain.request.MessageRequestDTO;
import com.example.gbwwebappbackend.domain.response.MessageResponseDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface VacancyService {
    void saveSubmittedApplication(
            String fullName,
            String email,
            String phone,
            String position,
            String content,
            MultipartFile file
    );
}
