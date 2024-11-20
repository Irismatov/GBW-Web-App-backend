package com.example.gbwwebappbackend.service.newsletter;

import com.example.gbwwebappbackend.entity.EmailForNewsLetter;
import com.example.gbwwebappbackend.repository.EmailForNewsLetterRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.regex.Matcher;

@Service
public class NewsLetterServiceImpl implements NewsLetterService {

    private final EmailForNewsLetterRepository emailForNewsLetterRepository;

    public NewsLetterServiceImpl(EmailForNewsLetterRepository emailForNewsLetterRepository) {
        this.emailForNewsLetterRepository = emailForNewsLetterRepository;
    }

    @Override
    public void save(String email) {

        email = email.strip();
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

        if (email.matches(emailRegex)) {
            if (!isExists(email)) {
                var emailForNewsLetter = new EmailForNewsLetter(UUID.randomUUID().toString(), email);
                emailForNewsLetterRepository.save(emailForNewsLetter);
            }
        }


    }

    private boolean isExists(String email) {
        return emailForNewsLetterRepository.isExistsBy(email);
    }
}
