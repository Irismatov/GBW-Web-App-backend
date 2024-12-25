package com.example.gbwwebappbackend.service.vacancy;


import com.example.gbwwebappbackend.entity.VacancyType;
import org.springframework.stereotype.Service;

@Service
public interface VacancyTypeService {

    VacancyType getVacancyTypeById(String id);
}
