package com.example.gbwwebappbackend.mapper;


import com.example.gbwwebappbackend.domain.request.VacancySaveRequestDTO;
import com.example.gbwwebappbackend.domain.response.VacancyResponseDTO;
import com.example.gbwwebappbackend.entity.vacancy.Vacancy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface VacancyMapper {
    Vacancy fromDtoToEntity(VacancySaveRequestDTO vacancySaveRequestDTO);

    VacancyResponseDTO fromEntityToDto(Vacancy vacancy);
}
