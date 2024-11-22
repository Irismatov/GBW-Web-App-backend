package com.example.gbwwebappbackend.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
public class VacancyApplication extends BaseModel{
    @Id
    private String id;
    private String fullName;
    private String phone;
    private String email;
    private String content;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "attachment_id", nullable = false)
    private Attachment attachment;
}
