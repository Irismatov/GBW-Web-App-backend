package com.example.gbwwebappbackend.domain.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class VacancyUpdateRequestDTO {
    private String title;
    private String content;
    private String status;
    private String publishDate;
}
