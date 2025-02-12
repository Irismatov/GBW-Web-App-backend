package com.example.gbwwebappbackend.service.vacancy;


import com.example.gbwwebappbackend.domain.request.VacancySaveRequestDTO;
import com.example.gbwwebappbackend.domain.request.VacancyUpdateRequestDTO;
import com.example.gbwwebappbackend.domain.response.VacancyResponseDTO;
import com.example.gbwwebappbackend.entity.VacancyType;
import com.example.gbwwebappbackend.entity.vacancy.Vacancy;
import com.example.gbwwebappbackend.entity.vacancy.VacancyStatus;
import com.example.gbwwebappbackend.mapper.VacancyMapper;
import com.example.gbwwebappbackend.repository.VacancyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
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


        // setting the status of vacancy
        if (Objects.nonNull(dto.getVacancyStatus()) && Objects.equals(dto.getVacancyStatus(), VacancyStatus.VACANCY_TEMPLATE) ) {
            vacancy.setStatus(dto.getVacancyStatus());
        } else {
            vacancy.setStatus(VacancyStatus.VACANCY_DRAFT);
        }

        return vacancyRepository.save(vacancy);
    }

    @Override
    public List<VacancyResponseDTO> getAllVacancies() {
        List<Vacancy> vacancies = vacancyRepository.findAll();

        return vacancies.stream().map(vacancy -> {
            return vacancyMapper.fromEntityToDto(vacancy);
        }).collect(Collectors.toList());
    }

    @Override
    public String deleteVacancyById(String id) {
        try {
            vacancyRepository.deleteByVacancyId(id);
            return "Success";
        } catch (Exception e) {
            return e.getMessage();
        }
    }


    @Override
    public List<VacancyResponseDTO> getVacancies(VacancyStatus status) {
        List<Vacancy> filteredVacancies = vacancyRepository.getFilteredVacancies(status.toString());
        return vacancyEntitiesToDTO(filteredVacancies);
    }

    @Override
    public void publishVacancy(String id) {
        vacancyRepository.publishVacancy(id);
    }

    @Override
    public VacancyResponseDTO update(String id, VacancyUpdateRequestDTO dto) {
        Vacancy vacancy = findById(id);
        if (Objects.nonNull(dto.getStatus())) {
            vacancy.setStatus(VacancyStatus.valueOf(dto.getStatus()));
        }

        if (Objects.nonNull(dto.getTitle())) {
            vacancy.setTitle(dto.getTitle());
        }
        if (Objects.nonNull(dto.getPublishDate())) {
            vacancy.setPublishDate(LocalDateTime.parse(dto.getPublishDate()));
        }

        if (Objects.nonNull(dto.getContent())) {
            vacancy.setContent(dto.getContent());
        }
        vacancy = vacancyRepository.save(vacancy);
        return vacancyMapper.fromEntityToDto(vacancy);
    }

    private List<VacancyResponseDTO> vacancyEntitiesToDTO(List<Vacancy> vacancies) {
        return vacancies.stream().map(vacancy -> {
            return vacancyMapper.fromEntityToDto(vacancy);
        }).collect(Collectors.toList());
    }

    @Override
    public Vacancy findById(String id) {
        return vacancyRepository.findById(id).orElseThrow(() -> new RuntimeException("Vacancy with id " + id + " not found"));
    }
}
