package com.example.gbwwebappbackend.service.vacancy;


import com.example.gbwwebappbackend.entity.Vacancy;
import com.example.gbwwebappbackend.entity.VacancyType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VacancyService {

    List<Vacancy> getAll();

    List<Vacancy> getByType(String type);
}
