package com.example.gbwwebappbackend.service.message;

import com.example.gbwwebappbackend.domain.request.MessageRequestDTO;
import com.example.gbwwebappbackend.domain.response.MessageResponseDTO;
import org.springframework.stereotype.Service;

@Service
public interface MessageService {
    MessageResponseDTO save(MessageRequestDTO message);
}
