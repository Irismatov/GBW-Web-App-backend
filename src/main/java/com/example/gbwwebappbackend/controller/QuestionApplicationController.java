package com.example.gbwwebappbackend.controller;

import com.example.gbwwebappbackend.domain.request.QuestionApplicationRequestAddingDto;
import com.example.gbwwebappbackend.service.question_application.QuestionApplicationService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("questions")
public class QuestionApplicationController {

    private final QuestionApplicationService questionApplicationService;

    public QuestionApplicationController(QuestionApplicationService questionApplicationService) {
        this.questionApplicationService = questionApplicationService;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Object> addQuestion(@RequestBody @Validated QuestionApplicationRequestAddingDto question) {

        questionApplicationService.saveQuestionApplication(question);

        return ResponseEntity.ok().build();

    }

}
