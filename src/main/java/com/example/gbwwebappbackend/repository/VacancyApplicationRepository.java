package com.example.gbwwebappbackend.repository;

import com.example.gbwwebappbackend.entity.VacancyApplication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VacancyApplicationRepository extends JpaRepository<VacancyApplication, String> {

}