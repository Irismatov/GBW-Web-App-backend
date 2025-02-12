package com.example.gbwwebappbackend.service.vacancy;


import com.example.gbwwebappbackend.domain.request.VacancySaveRequestDTO;
import com.example.gbwwebappbackend.domain.request.VacancyUpdateRequestDTO;
import com.example.gbwwebappbackend.domain.response.VacancyResponseDTO;
import com.example.gbwwebappbackend.entity.vacancy.Vacancy;
import com.example.gbwwebappbackend.entity.vacancy.VacancyStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface VacancyService {


    Vacancy save(VacancySaveRequestDTO dto);

    List<VacancyResponseDTO> getAllVacancies();

    String deleteVacancyById(String id);
    List<VacancyResponseDTO> getVacancies(VacancyStatus status);
    void publishVacancy(String id);
    VacancyResponseDTO update(String id, VacancyUpdateRequestDTO dto);
    Vacancy findById(String id);
}
