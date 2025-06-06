package com.example.gbwwebappbackend.domain.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
public class MessageRequestDTO {
    @NotBlank
    @Length(min = 3, max = 30)
    private String firstName;
    @NotBlank
    @Length(min = 3, max = 30)
    private String lastName;
    @NotBlank
    @Length(min = 3, max = 100)
    private String company;
    @Email
    private String email;
    @NotBlank
    @Length(min = 9, max = 16)
    private String phone;
    private String content;
}
