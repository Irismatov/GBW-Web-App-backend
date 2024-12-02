package com.example.gbwwebappbackend.service.question_application;

import com.example.gbwwebappbackend.domain.request.QuestionApplicationRequestAddingDto;
import com.example.gbwwebappbackend.entity.QuestionApplication;
import org.springframework.stereotype.Service;

@Service
public interface QuestionApplicationService {
    void saveQuestionApplication(QuestionApplicationRequestAddingDto requestAddingDto);
}
