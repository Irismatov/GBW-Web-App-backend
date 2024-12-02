package com.example.gbwwebappbackend.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class Vacancy extends BaseModel{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long vacancyId;
    private String title;
    private String description;
    @NotNull
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "vacancy_type_id", nullable = false)
    private VacancyType type;
}
