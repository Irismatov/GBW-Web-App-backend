package com.example.gbwwebappbackend.entity.vacancyApplication;


import com.example.gbwwebappbackend.entity.Attachment;
import com.example.gbwwebappbackend.entity.BaseModel;
import com.example.gbwwebappbackend.entity.VacancyType;
import com.example.gbwwebappbackend.entity.vacancy.Vacancy;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class VacancyApplication extends BaseModel {
    @Id
    private String id;
    private String fullName;
    private String email;
    private String phone;
    private String motivation;
    @Enumerated(value = EnumType.STRING)
    private VacancyApplicationStatus status;

    @JoinColumn(name = "vacancy_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Vacancy vacancy;

    @NotNull
    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "attachment_id", nullable = false)
    private Attachment attachment;
}
