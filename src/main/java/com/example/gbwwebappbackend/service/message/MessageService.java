package com.example.gbwwebappbackend.service.message;

import com.example.gbwwebappbackend.domain.request.MessageRequestDTO;
import com.example.gbwwebappbackend.domain.response.PageResponseDto;
import com.example.gbwwebappbackend.domain.response.contactmessage.MessageResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MessageService {
    void save(MessageRequestDTO message);

    PageResponseDto getAsPaging(int page, int size);

    MessageResponseDTO getBy(String id);
}
