package com.example.gbwwebappbackend.domain.request;


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
    private String description;
    private String responsibilities;
    private String offers;
    private String requirements;
    private String vacancyTypeId;
    private String terms;
}
