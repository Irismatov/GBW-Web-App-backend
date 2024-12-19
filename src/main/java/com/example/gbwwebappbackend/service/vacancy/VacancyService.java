package com.example.gbwwebappbackend.service.vacancy;


import com.example.gbwwebappbackend.domain.request.VacancySaveRequestDTO;
import com.example.gbwwebappbackend.domain.response.VacancyResponseDTO;
import com.example.gbwwebappbackend.entity.Vacancy;
import com.example.gbwwebappbackend.entity.VacancyType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VacancyService {


    Vacancy save(VacancySaveRequestDTO dto);

    List<VacancyResponseDTO> getAllVacancies();
}
