package com.example.gbwwebappbackend.controller;

import com.example.gbwwebappbackend.service.vacancy.VacancyService;
import com.example.gbwwebappbackend.service.vacancy_application.VacancyApplicationService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@RestController
@RequestMapping("/vacancy")
public class VacancyController {

    private final VacancyApplicationService vacancyApplicationService;
    private final VacancyService vacancyService;

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

        vacancyApplicationService.saveSubmittedApplication(fullName, email, phone, position, content, file);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/getVacancies")
    public ResponseEntity<Object> getVacancies() {
        return ResponseEntity.ok(vacancyService.getAll());
    }

    @GetMapping("/getByType")
    public ResponseEntity<Object> getVacancyTypes(@RequestParam("typeId") String typeId) {
        return ResponseEntity.ok(vacancyService.getByType(typeId));
    }
}


