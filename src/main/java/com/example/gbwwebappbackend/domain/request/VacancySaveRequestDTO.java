package com.example.gbwwebappbackend.domain.request;


import com.example.gbwwebappbackend.entity.VacancyType;
import com.example.gbwwebappbackend.entity.vacancy.VacancyStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VacancySaveRequestDTO {
    private String title;
    private String content;
    private VacancyStatus vacancyStatus;
}
