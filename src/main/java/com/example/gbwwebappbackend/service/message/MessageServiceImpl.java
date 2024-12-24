package com.example.gbwwebappbackend.service.message;

import com.example.gbwwebappbackend.domain.request.MessageRequestDTO;
import com.example.gbwwebappbackend.domain.request.message.IsReadMessageReqDto;
import com.example.gbwwebappbackend.domain.response.PageResponseDto;
import com.example.gbwwebappbackend.domain.response.contactmessage.MessageResponseDTO;
import com.example.gbwwebappbackend.entity.Message;
import com.example.gbwwebappbackend.mapper.MessageMapper;
import com.example.gbwwebappbackend.repository.MessageRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;
    private final MessageMapper messageMapper;

    @Override
    public boolean isReadMessage(IsReadMessageReqDto isReadMessageDto) {

        System.out.println("isReadMessageDto = " + isReadMessageDto);
        int i = messageRepository.updateIsReadById(isReadMessageDto.getIsRead(), isReadMessageDto.getId());

        return i > 0;
    }

    @Override
    public void save(MessageRequestDTO message) {
        Message entity = messageMapper.fromDtoToEntity(message);

        entity.setId(UUID.randomUUID().toString());

        messageRepository.save(entity);
    }

    @Override
    public PageResponseDto getAsPaging(int page, int size) {

        PageRequest pageable = PageRequest.of(page - 1, size, Sort.Direction.DESC, "createdAt");

        Page<Message> all = messageRepository.findAll(pageable);

        List<MessageResponseDTO> responseDTOList = new ArrayList<>();

        all.toList().forEach(message -> {
            var messageResponseDTO = messageMapper.fromEntityToDto(message);
            messageResponseDTO.setCreatedTime(String.valueOf(message.getCreatedAt().toEpochSecond(ZoneOffset.UTC)));
            responseDTOList.add(messageResponseDTO);
        });

        return PageResponseDto.builder()
                .contents(responseDTOList)
                .hasNext(all.hasNext())
                .hasPrevious(all.hasPrevious())
                .totalPages(all.getTotalPages())
                .numberOfElements(responseDTOList.size())
                .totalElements(all.getTotalElements())
                .pageNumber(all.getNumber()+1)
                .isFirst(all.isFirst())
                .isLast(all.isLast())
                .size(all.getSize())
                .build();

    }

    @Override
    public MessageResponseDTO getBy(String id) {
        Optional<Message> byId = messageRepository.findById(id);
        if (byId.isEmpty()) {
            throw new RuntimeException("Message not found");
        }
        return messageMapper.fromEntityToDto(byId.get());
    }
}
