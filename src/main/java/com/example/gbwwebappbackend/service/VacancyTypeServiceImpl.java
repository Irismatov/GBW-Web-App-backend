package com.example.gbwwebappbackend.service;


import com.example.gbwwebappbackend.entity.VacancyType;
import com.example.gbwwebappbackend.repository.VacancyTypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class VacancyTypeServiceImpl implements VacancyTypeService {

    private final VacancyTypeRepository vacancyTypeRepository;

    @Override
    public VacancyType getVacancyTypeById(String id) {
        return vacancyTypeRepository.findById(id).orElseThrow(() ->(new RuntimeException("Type not found")));
    }
}
