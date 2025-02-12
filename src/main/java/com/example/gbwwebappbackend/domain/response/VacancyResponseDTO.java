package com.example.gbwwebappbackend.domain.response;


import com.example.gbwwebappbackend.entity.vacancy.VacancyStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class VacancyResponseDTO {
    private String vacancyId;
    private String title;
    private String content;
    private boolean isActive;
    private VacancyStatus status;
    private LocalDateTime publishDate;
}
