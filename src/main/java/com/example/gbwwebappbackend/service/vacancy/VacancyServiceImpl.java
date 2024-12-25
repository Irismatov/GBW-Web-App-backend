package com.example.gbwwebappbackend.service.vacancy;


import com.example.gbwwebappbackend.entity.Vacancy;
import com.example.gbwwebappbackend.repository.VacancyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class VacancyServiceImpl implements VacancyService{
    private VacancyRepository vacancyRepository;

    private VacancyTypeService vacancyTypeService;

    @Override
    public List<Vacancy> getAll() {
        return vacancyRepository.findAll();
    }

    @Override
    public List<Vacancy> getByType(String type) {
        return vacancyRepository.getVacanciesByType(vacancyTypeService.getVacancyTypeById(type));
    }


}
