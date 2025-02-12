package com.example.gbwwebappbackend.domain.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PdfResponse {
    private String fileId;
    private String filePath;
}
