package com.example.gbwwebappbackend.controller;

import com.example.gbwwebappbackend.domain.request.GetVacancyApplicationRequestDTO;
import com.example.gbwwebappbackend.domain.response.PdfResponse;
import com.example.gbwwebappbackend.entity.vacancyApplication.VacancyApplication;
import com.example.gbwwebappbackend.service.attachment.AttachmentService;
import com.example.gbwwebappbackend.service.vacancy_application.VacancyApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.nio.file.Files;
import java.nio.file.Paths;


@RestController
@RequestMapping("/vacancyApplication")
@RequiredArgsConstructor
public class VacancyApplicationController {

    private final VacancyApplicationService vacancyApplicationService;
    private final AttachmentService attachmentService;


    @GetMapping
    public ResponseEntity<Page<VacancyApplication>> getAllVacancyApplications(
            @RequestParam(value = "fullName", required = false) String fullName,
            @RequestParam(value = "email", required = false) String email,
            @RequestParam(value = "startDate", required = false) String startDate,
            @RequestParam(value = "endDate", required = false) String endDate,
            @RequestParam(value = "status", required = false) String status,
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "size", defaultValue = "10") int size)
    {
        GetVacancyApplicationRequestDTO dto = new GetVacancyApplicationRequestDTO();
        dto.setFullName(fullName);
        dto.setEmail(email);
        dto.setStartDate(startDate);
        dto.setEndDate(endDate);
        dto.setStatus(status);
        Page<VacancyApplication> vacancyApplications = vacancyApplicationService.getVacancyApplications(dto, PageRequest.of(page-1, size));
        return ResponseEntity.ok().body(vacancyApplications);
    }

    @PatchMapping("/{applicationId}/")
    public ResponseEntity<VacancyApplication> updateVacancyApplicationStatus(@PathVariable(value = "applicationId") String applicationId,
                                                                             @RequestParam("status")String status) {
        VacancyApplication updatedVacancyApplication = vacancyApplicationService
                .updateVacancyApplicationStatus(applicationId, status);
        return ResponseEntity.ok().body(updatedVacancyApplication);
    }

    @GetMapping("/pdf/{fileId}")
    public ResponseEntity<Resource> downloadPdf(@PathVariable String fileId) {
        try {
            try {
                Files.list(Paths.get("D:\\GBWAYFILES\\Resumes"))
                        .forEach(System.out::println);
            } catch (AccessDeniedException e) {
                System.err.println("Access denied: " + e.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
            }

            PdfResponse document = attachmentService.getDocument(fileId);

            Resource resource = new FileSystemResource(document.getFilePath());


            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_PDF)
                    .header(HttpHeaders.CONTENT_DISPOSITION,
                            "attachment; filename=\"" + document.getFileId() + "\"")
                    .body(resource);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{applicationId}")
    public ResponseEntity<String> deleteVacancyApplication(@PathVariable String applicationId) {
        String response = vacancyApplicationService.deleteVacancyApplication(applicationId);
        return ResponseEntity.ok().body(response);
    }
}
