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
public class Attachment extends BaseModel {
    @Id
    private String id;
    private String extension;
    private String pathDirectory;

}
