package com.example.gbwwebappbackend.repository;

import com.example.gbwwebappbackend.entity.EmailForNewsLetter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmailForNewsLetterRepository extends JpaRepository<EmailForNewsLetter, String> {
    @Query("select (count(e) > 0) from EmailForNewsLetter e where upper(e.email) = upper(?1)")
    boolean isExistsBy(String email);
}