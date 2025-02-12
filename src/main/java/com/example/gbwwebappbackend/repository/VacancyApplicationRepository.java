package com.example.gbwwebappbackend.repository;

import com.example.gbwwebappbackend.entity.vacancyApplication.VacancyApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

public interface VacancyApplicationRepository extends JpaRepository<VacancyApplication, String> {

    @Transactional
    @Query(value = "SELECT va.* FROM vacancy_application va WHERE "
            + "(:fullName IS NULL OR va.full_name ILIKE '%' || :fullName || '%') "
            + "AND (:status IS NULL OR va.status = :status) "
            + "AND (:startDate IS NULL OR va.created_at >= (:startDate)::timestamp)"
            + "AND (:endDate IS NULL OR va.created_at <= (:endDate)::timestamp) "
            + "AND (:email IS NULL OR va.email ILIKE '%' || :email || '%') "
            + "AND (:phone IS NULL OR va.phone ILIKE '%' || :phone || '%')"
            + "AND (va.is_active is TRUE)" +
            "ORDER BY va.created_at DESC",
            countQuery = "SELECT COUNT(*) FROM vacancy_application va WHERE "
                    + "(:fullName IS NULL OR va.full_name ILIKE '%' ||  :fullName || '%') "
                    + "AND (:status IS NULL OR va.status = :status) "
                    + "AND (:startDate IS NULL OR va.created_at >= (:startDate)::timestamp) "
                    + "AND (:endDate IS NULL OR va.created_at <= (:endDate)::timestamp) "
                    + "AND (:email IS NULL OR va.email ILIKE '%' || :email || '%') "
                    + "AND (:phone IS NULL OR va.phone ILIKE '%' || :phone || '%')"
                    + "AND (va.is_active is TRUE)",
            nativeQuery = true)
    Page<VacancyApplication> getFilteredVacancyApplications(
            @Param("fullName") String fullName,
            @Param("status") String status,
            @Param("startDate") String startDate,
            @Param("endDate") String endDate,
            @Param("email") String email,
            @Param("phone") String phone,
            Pageable pageable);

    @Transactional
    @Modifying
    @Query("UPDATE VacancyApplication va SET va.isActive = false WHERE va.id = :id")
    void deleteVacancyApplication(@Param("id") String id);


}