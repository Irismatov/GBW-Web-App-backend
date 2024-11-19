package com.example.gbwwebappbackend.mapper;


import com.example.gbwwebappbackend.domain.request.MessageRequestDTO;
import com.example.gbwwebappbackend.domain.response.MessageResponseDTO;
import com.example.gbwwebappbackend.entity.Message;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface MessageMapper {
    Message fromDtoToEntity (MessageRequestDTO messageRequestDTO);
    MessageResponseDTO fromEntityToDto (Message message);
}
