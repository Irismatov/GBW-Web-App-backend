package com.example.gbwwebappbackend.domain.request.message;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class IsReadMessageReqDto {
    @NotNull
    @NotBlank
    private String id;

    @NotNull
    private Boolean isRead;
}
