package com.example.gbwwebappbackend.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Message extends BaseModel {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String company;
    private String email;
    private String phone;
    @Column(nullable = false)
    private boolean isRead;
    @Column(length = 10000)
    private String content;

    @Override
    protected void onCreate() {
        super.setActive(true);
        isRead = false;
    }

}
