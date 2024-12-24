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
    private String id;
    private String title;
    private String content;
    private boolean isActive;
}
