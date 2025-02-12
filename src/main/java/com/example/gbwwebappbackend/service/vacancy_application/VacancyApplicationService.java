package com.example.gbwwebappbackend.service.vacancy_application;

import com.example.gbwwebappbackend.domain.request.GetVacancyApplicationRequestDTO;
import com.example.gbwwebappbackend.entity.vacancyApplication.VacancyApplication;
import com.example.gbwwebappbackend.entity.vacancyApplication.VacancyApplicationStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface VacancyApplicationService {
    void saveSubmittedApplication(
            String fullName, String email, MultipartFile file, String vacancyId, String phone, String motivation
    );

    Page<VacancyApplication> getVacancyApplications(GetVacancyApplicationRequestDTO dto, Pageable pageable);

    VacancyApplication updateVacancyApplicationStatus(String vacancyId, String status);
}
