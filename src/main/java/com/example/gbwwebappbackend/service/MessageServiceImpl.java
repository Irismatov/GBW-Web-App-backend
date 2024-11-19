package com.example.gbwwebappbackend.service;

import com.example.gbwwebappbackend.domain.request.MessageRequestDTO;
import com.example.gbwwebappbackend.domain.response.MessageResponseDTO;
import com.example.gbwwebappbackend.entity.Message;
import com.example.gbwwebappbackend.mapper.MessageMapper;
import com.example.gbwwebappbackend.repository.MessageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;
    private final MessageMapper messageMapper;

    @Override
    public MessageResponseDTO save(MessageRequestDTO message) {
        Message save = messageRepository.save(messageMapper.fromDtoToEntity(message));
        return messageMapper.fromEntityToDto(save);
    }
}
