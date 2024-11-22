package com.example.gbwwebappbackend.service.vacancy;

import com.example.gbwwebappbackend.entity.Attachment;
import com.example.gbwwebappbackend.entity.EmailForNewsLetter;
import com.example.gbwwebappbackend.entity.VacancyApplication;
import com.example.gbwwebappbackend.repository.AttachmentRepository;
import com.example.gbwwebappbackend.repository.EmailForNewsLetterRepository;
import com.example.gbwwebappbackend.repository.VacancyApplicationRepository;
import com.example.gbwwebappbackend.service.attachment.AttachmentService;
import com.example.gbwwebappbackend.service.newsletter.NewsLetterService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Service
public class VacancyServiceImpl implements VacancyService {

    private final VacancyApplicationRepository vacancyApplicationRepository;
    private final AttachmentRepository attachmentRepository;
    private final AttachmentService attachmentService;

    public VacancyServiceImpl(VacancyApplicationRepository vacancyApplicationRepository,
                              AttachmentRepository attachmentRepository, AttachmentService attachmentService) {
        this.vacancyApplicationRepository = vacancyApplicationRepository;
        this.attachmentRepository = attachmentRepository;
        this.attachmentService = attachmentService;
    }

    @Override
    public void saveSubmittedApplication(String fullName, String email, String phone, String position, String content, MultipartFile file) {
        var vacancyApplication = new VacancyApplication();

        Attachment savedAttachment = attachmentService.save(file);

        vacancyApplication.setId(UUID.randomUUID().toString());
        vacancyApplication.setFullName(fullName);
        vacancyApplication.setEmail(email);
        vacancyApplication.setPhone(phone);
        vacancyApplication.setContent(content);
        vacancyApplication.setAttachment(savedAttachment);

        vacancyApplicationRepository.save(vacancyApplication);

    }
}
