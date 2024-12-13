package com.example.gbwwebappbackend.domain.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class VacancyResponseDTO {
    private long id;
    private String title;
    private String description;
    private String terms;
    private String requirements;
    private String offers;
    private String typeName;
    private String responsibilities;
}
