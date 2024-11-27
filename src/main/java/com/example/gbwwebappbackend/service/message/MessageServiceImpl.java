package com.example.gbwwebappbackend.service.message;

import com.example.gbwwebappbackend.domain.request.MessageRequestDTO;
import com.example.gbwwebappbackend.domain.response.MessageResponseDTO;
import com.example.gbwwebappbackend.entity.Message;
import com.example.gbwwebappbackend.mapper.MessageMapper;
import com.example.gbwwebappbackend.repository.MessageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;
    private final MessageMapper messageMapper;

    @Override
    public MessageResponseDTO save(MessageRequestDTO message) {
        Message entity = messageMapper.fromDtoToEntity(message);

        entity.setId(UUID.randomUUID().toString());

        Message save = messageRepository.save(entity);
        return messageMapper.fromEntityToDto(save);
    }
}
