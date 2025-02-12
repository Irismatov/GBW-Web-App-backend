package com.example.gbwwebappbackend.controller;

import com.example.gbwwebappbackend.domain.request.VacancySaveRequestDTO;
import com.example.gbwwebappbackend.domain.request.VacancyUpdateRequestDTO;
import com.example.gbwwebappbackend.entity.vacancy.VacancyStatus;
import com.example.gbwwebappbackend.service.vacancy.VacancyService;
import com.example.gbwwebappbackend.service.vacancy_application.VacancyApplicationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Objects;

@AllArgsConstructor
@RestController
@RequestMapping("/vacancy")
public class VacancyController {

    private final VacancyApplicationService vacancyApplicationService;
    private final VacancyService vacancyService;


    @PostMapping(value = "/submit-application", consumes = "multipart/form-data")
    public ResponseEntity<Object> uploadFile(
            @RequestPart("file") MultipartFile file,
            @RequestPart("fullName") String fullName,
            @RequestPart("email") String email,
            @RequestPart("motivation") String motivation,
            @RequestPart(value = "vacancyId", required = false) String vacancyId,
            @RequestPart("phone") String phone
    ) {

        vacancyApplicationService.saveSubmittedApplication(fullName, email, file, vacancyId, phone, motivation);

        return ResponseEntity.ok().build();
    }


    @PostMapping("/saveVacancy")
    public ResponseEntity<Object> saveVacancy(@RequestBody VacancySaveRequestDTO dto) {
        return ResponseEntity.ok(vacancyService.save(dto));
    }

    @GetMapping("/getAllVacancies")
    public ResponseEntity<Object> getAllVacancies() {
        return ResponseEntity.ok(vacancyService.getAllVacancies());
    }


    @GetMapping
    public ResponseEntity<Object> getVacancies(@RequestParam("status") VacancyStatus status) {
        return ResponseEntity.ok(vacancyService.getVacancies(status));
    }

    @DeleteMapping("/{vacancyId}")
    public ResponseEntity<String> deleteVacancy(@PathVariable("vacancyId") String vacancyId) {
        String message = vacancyService.deleteVacancyById(vacancyId);
        return Objects.equals(message, "Success") ? ResponseEntity.ok(message) :
                ResponseEntity.status(HttpStatusCode.valueOf(400)).body(message);
    }

    @PostMapping("/publishVacancy/{vacancyId}")
    public ResponseEntity<Object> publishVacancy(@PathVariable("vacancyId") String vacancyId) {
        vacancyService.publishVacancy(vacancyId);
        return ResponseEntity.ok().body("Success");
    }

    @PutMapping("/{vacancyId}")
    public ResponseEntity<Object> updateVacancy(@PathVariable("vacancyId") String vacancyId,
                                                @RequestBody VacancyUpdateRequestDTO dto) {
        return ResponseEntity.ok(vacancyService.update(vacancyId, dto));
    }

}


