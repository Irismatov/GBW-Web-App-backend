package com.example.gbwwebappbackend.controller;

import com.example.gbwwebappbackend.service.vacancy.VacancyService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/vacancy")
public class VacancyController {

    private final VacancyService vacancyService;

    public VacancyController(VacancyService vacancyService) {
        this.vacancyService = vacancyService;
    }

    //    @CrossOrigin
    @PostMapping(value = "/submit-application", consumes = "multipart/form-data")
    public ResponseEntity<Object> uploadFile(
            @RequestPart("file") MultipartFile file,
            @RequestPart("fullName") String fullName,
            @RequestPart("email") String email,
            @RequestPart("phone") String phone,
            @RequestPart("position") String position,
            @RequestPart(value = "content", required = false) String content
    ) {

        vacancyService.saveSubmittedApplication(fullName, email, phone, position, content, file);

        return ResponseEntity.ok().build();

    }
}


