package com.example.gbwwebappbackend.service.vacancy_application;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface VacancyApplicationService {
    void saveSubmittedApplication(
            String fullName,
            String email,
            String phone,
            String position,
            String content,
            MultipartFile file
    );
}
