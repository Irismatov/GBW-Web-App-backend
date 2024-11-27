package com.example.gbwwebappbackend.repository;


import com.example.gbwwebappbackend.entity.Vacancy;
import com.example.gbwwebappbackend.entity.VacancyType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VacancyRepository extends JpaRepository<Vacancy, Long> {

    List<Vacancy> getVacanciesByType(VacancyType type);
}
