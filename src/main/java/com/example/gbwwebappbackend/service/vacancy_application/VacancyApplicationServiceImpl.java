package com.example.gbwwebappbackend.service.vacancy_application;

import com.example.gbwwebappbackend.domain.request.GetVacancyApplicationRequestDTO;
import com.example.gbwwebappbackend.entity.Attachment;
import com.example.gbwwebappbackend.entity.vacancyApplication.VacancyApplication;
import com.example.gbwwebappbackend.entity.vacancy.Vacancy;
import com.example.gbwwebappbackend.entity.vacancyApplication.VacancyApplicationStatus;
import com.example.gbwwebappbackend.repository.VacancyApplicationRepository;
import com.example.gbwwebappbackend.service.attachment.AttachmentService;
import com.example.gbwwebappbackend.service.vacancy.VacancyService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.UUID;

import static com.example.gbwwebappbackend.util.DateTimeFormatter.formatter;

@RequiredArgsConstructor
@Service
public class VacancyApplicationServiceImpl implements VacancyApplicationService {

    private final VacancyApplicationRepository vacancyApplicationRepository;
    private final AttachmentService attachmentService;
    private final VacancyService vacancyService;

    @Override
    public void saveSubmittedApplication(String fullName, String email, MultipartFile file, String vacancyId,
                                         String phone, String motivation) {
        var vacancyApplication = new VacancyApplication();
        Attachment savedAttachment = attachmentService.save(file);

        vacancyApplication.setId(UUID.randomUUID().toString());
        vacancyApplication.setFullName(fullName);
        vacancyApplication.setEmail(email);
        vacancyApplication.setPhone(phone);
        vacancyApplication.setMotivation(motivation);
        if (vacancyId != null) {
            Vacancy vacancy = vacancyService.findById(vacancyId);
            vacancyApplication.setVacancy(vacancy);
        }
        vacancyApplication.setStatus(VacancyApplicationStatus.APPLICATION_RECEIVED);
        vacancyApplication.setAttachment(savedAttachment);
        vacancyApplicationRepository.save(vacancyApplication);
    }

    @Transactional
    @Override
    public Page<VacancyApplication> getVacancyApplications(GetVacancyApplicationRequestDTO dto, Pageable pageable) {
        Page<VacancyApplication> filteredVacancyApplications = vacancyApplicationRepository.getFilteredVacancyApplications(
                dto.getFullName(),
                dto.getStatus(),
                dto.getStartDate(),
                dto.getEndDate(),
                dto.getEmail(),
                dto.getPhone(),
                pageable
        );
        return filteredVacancyApplications;
    }

    @Override
    public VacancyApplication updateVacancyApplicationStatus(String vacancyId, String status) {
        Optional<VacancyApplication> vacancyApplicationOptional = vacancyApplicationRepository.findById(vacancyId);
        VacancyApplication vacancyApplication = vacancyApplicationOptional.
                orElseThrow(() -> new RuntimeException("Vacancy application not found with id: " + vacancyId));
        VacancyApplicationStatus newStatus = VacancyApplicationStatus.valueOf(status);
        vacancyApplication.setStatus(newStatus);
        VacancyApplication save = vacancyApplicationRepository.save(vacancyApplication);
        return save;
    }

    @Override
    public String deleteVacancyApplication(String vacancyId) {
        vacancyApplicationRepository.deleteVacancyApplication(vacancyId);
        return "Application deleted successfully";
    }
}
