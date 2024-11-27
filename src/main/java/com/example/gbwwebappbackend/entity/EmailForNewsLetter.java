package com.example.gbwwebappbackend.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class EmailForNewsLetter extends BaseModel {
    @Id
    private String id;

    @Column(unique = true)
    private String email;
}
