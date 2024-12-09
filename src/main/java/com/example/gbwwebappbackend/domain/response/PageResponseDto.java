package com.example.gbwwebappbackend.domain.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PageResponseDto {

    private Object contents;
    private long totalElements;
    private int totalPages;
    private int pageNumber;
    private int size;
    private int numberOfElements;
    private boolean hasNext;
    private boolean hasPrevious;
    private boolean isFirst;
    private boolean isLast;


}
