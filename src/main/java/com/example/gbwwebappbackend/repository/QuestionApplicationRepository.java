package com.example.gbwwebappbackend.repository;

import com.example.gbwwebappbackend.entity.QuestionApplication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionApplicationRepository extends JpaRepository<QuestionApplication, String> {
}