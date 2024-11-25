package com.example.gbwwebappbackend.repository;

import com.example.gbwwebappbackend.entity.VacancyType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VacancyTypeRepository extends JpaRepository<VacancyType, String> {

    Optional<VacancyType> findById(String id);
}
