package com.example.gbwwebappbackend.service.message;

import com.example.gbwwebappbackend.domain.request.MessageRequestDTO;
import com.example.gbwwebappbackend.domain.response.MessageResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MessageService {
    MessageResponseDTO save(MessageRequestDTO message);

    List<MessageResponseDTO> getAsPaging(int page, int size);

    MessageResponseDTO getBy(String id);
}
