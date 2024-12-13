package com.example.gbwwebappbackend.service.vacancy;


import com.example.gbwwebappbackend.domain.request.VacancySaveRequestDTO;
import com.example.gbwwebappbackend.domain.response.VacancyResponseDTO;
import com.example.gbwwebappbackend.entity.Vacancy;
import com.example.gbwwebappbackend.mapper.VacancyMapper;
import com.example.gbwwebappbackend.repository.VacancyRepository;
import com.example.gbwwebappbackend.service.VacancyTypeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class VacancyServiceImpl implements VacancyService{
    private VacancyRepository vacancyRepository;

    private VacancyTypeService vacancyTypeService;
    private VacancyMapper vacancyMapper;

    @Override
    public List<Vacancy> getByType(String type) {
        return vacancyRepository.getVacanciesByType(vacancyTypeService.getVacancyTypeById(type));
    }

    @Override
    public Vacancy save(VacancySaveRequestDTO dto) {
        Vacancy vacancy = vacancyMapper.fromDtoToEntity(dto);
        vacancy.setType(vacancyTypeService.getVacancyTypeById(dto.getVacancyTypeId()));
        return vacancyRepository.save(vacancy);
    }

    @Override
    public List<VacancyResponseDTO> getAllVacancies() {
        List<Vacancy> vacancies = vacancyRepository.findAll();

        return vacancies.stream().map(vacancy -> {
            VacancyResponseDTO vacancyResponseDTO = vacancyMapper.fromEntityToDto(vacancy);
            vacancyResponseDTO.setTypeName(vacancy.getType().getNameUz());
            return vacancyResponseDTO;
        }).collect(Collectors.toList());
    }


}
