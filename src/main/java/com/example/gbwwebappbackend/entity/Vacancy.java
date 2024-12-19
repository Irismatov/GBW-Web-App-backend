package com.example.gbwwebappbackend.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Vacancy extends BaseModel{
    @Id
    private String vacancyId;
    private String title;
    @Lob
    private String content;
}
