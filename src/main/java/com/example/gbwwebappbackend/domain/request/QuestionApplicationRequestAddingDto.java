package com.example.gbwwebappbackend.domain.request;

import com.example.gbwwebappbackend.entity.QuestionApplication;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.io.Serializable;

/**
 * DTO for {@link QuestionApplication}
 */
@Data
public class QuestionApplicationRequestAddingDto implements Serializable {
    @NotBlank
    String firstName;

    @NotBlank
    @Email
    String email;
    String content;
}