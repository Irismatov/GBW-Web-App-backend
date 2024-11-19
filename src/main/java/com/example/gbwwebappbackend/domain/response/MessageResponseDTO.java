package com.example.gbwwebappbackend.domain.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MessageResponseDTO {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String content;
}
