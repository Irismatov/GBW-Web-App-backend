package com.example.gbwwebappbackend.service.question_application;

import com.example.gbwwebappbackend.domain.request.QuestionApplicationRequestAddingDto;
import com.example.gbwwebappbackend.entity.QuestionApplication;
import com.example.gbwwebappbackend.mapper.MessageMapper;
import com.example.gbwwebappbackend.repository.QuestionApplicationRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class QuestionApplicationServiceImpl implements QuestionApplicationService {
    private final QuestionApplicationRepository questionApplicationRepository;
    private final MessageMapper messageMapper;

    public QuestionApplicationServiceImpl(QuestionApplicationRepository questionApplicationRepository,
                                          MessageMapper messageMapper) {
        this.questionApplicationRepository = questionApplicationRepository;
        this.messageMapper = messageMapper;
    }

    @Override
    public void saveQuestionApplication(QuestionApplicationRequestAddingDto requestAddingDto) {

        QuestionApplication entity = messageMapper.toEntity(requestAddingDto);

        entity.setId(UUID.randomUUID().toString());

        questionApplicationRepository.save(entity);
    }
}
