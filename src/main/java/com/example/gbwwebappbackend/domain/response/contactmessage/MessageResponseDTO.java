package com.example.gbwwebappbackend.domain.response.contactmessage;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MessageResponseDTO {
    private String id;
    private String firstName;
    private String lastName;
    private String company;
    private String email;
    private String phone;
    private boolean isRead;
    private boolean isActive;
    private String content;
    private String createdTime;

}
