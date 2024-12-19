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
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class VacancyServiceImpl implements VacancyService{
    private VacancyRepository vacancyRepository;

    private VacancyMapper vacancyMapper;



    @Override
    public Vacancy save(VacancySaveRequestDTO dto) {
        Vacancy vacancy = vacancyMapper.fromDtoToEntity(dto);
        vacancy.setVacancyId(UUID.randomUUID().toString());
        return vacancyRepository.save(vacancy);
    }

    @Override
    public List<VacancyResponseDTO> getAllVacancies() {
        List<Vacancy> vacancies = vacancyRepository.findAll();

        return vacancies.stream().map(vacancy -> {
            return vacancyMapper.fromEntityToDto(vacancy);
        }).collect(Collectors.toList());
    }


}
