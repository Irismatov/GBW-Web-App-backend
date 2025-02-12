package com.example.gbwwebappbackend.repository;


import com.example.gbwwebappbackend.entity.vacancy.Vacancy;
import com.example.gbwwebappbackend.entity.vacancy.VacancyStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public interface VacancyRepository extends JpaRepository<Vacancy, String> {

    @Modifying
    @Transactional
    @Query("UPDATE Vacancy v SET v.isActive = false WHERE v.vacancyId = :id")
    void deleteByVacancyId(@Param("id") String id);

    @Transactional
    @Query(value = "SELECT * FROM vacancies v WHERE " +
            "(:status IS NULL OR v.status = :status) AND v.is_active = true", nativeQuery = true)
    List<Vacancy> getFilteredVacancies(@Param("status") String status);

    @Transactional
    @Modifying
    @Query("UPDATE Vacancy v SET v.status = 'VACANCY_PUBLISHED', v.publishDate = CURRENT_TIMESTAMP WHERE v.vacancyId = :id")
    void publishVacancy(@Param("id") String id);

}
