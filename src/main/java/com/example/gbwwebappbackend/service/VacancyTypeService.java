package com.example.gbwwebappbackend.service;


import com.example.gbwwebappbackend.entity.VacancyType;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface VacancyTypeService {

    VacancyType getVacancyTypeById(String id);

    List<VacancyType> getAllVacancyTypes();

}
