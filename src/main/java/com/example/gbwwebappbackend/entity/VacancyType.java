package com.example.gbwwebappbackend.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class VacancyType extends BaseModel {
    @Id
    private String id;
    private String nameEn;
    private String nameUz;
    private String nameRu;
}
