package com.example.gbwwebappbackend.entity.vacancy;


import com.example.gbwwebappbackend.entity.BaseModel;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "vacancies")
public class Vacancy extends BaseModel {
    @Id
    private String vacancyId;
    private String title;
    @Lob
    private String content;
    @Enumerated(EnumType.STRING)
    private VacancyStatus status;
    private LocalDateTime publishDate;
}
