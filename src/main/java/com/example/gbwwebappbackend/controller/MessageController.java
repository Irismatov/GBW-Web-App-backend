package com.example.gbwwebappbackend.controller;


import com.example.gbwwebappbackend.domain.request.MessageRequestDTO;
import com.example.gbwwebappbackend.domain.response.PageResponseDto;
import com.example.gbwwebappbackend.domain.response.contactmessage.MessageResponseDTO;
import com.example.gbwwebappbackend.service.message.MessageService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/contact/message")
public class MessageController {
    private final MessageService messageService;

    @PostMapping
    public ResponseEntity<Object> sendMessage(@RequestBody MessageRequestDTO message) {
        messageService.save(message);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(value = "/get/custom")
    public ResponseEntity<Object> getMessage(@RequestParam int page, @RequestParam int size) {

        PageResponseDto asPaging = messageService.getAsPaging(page, size);

        return ResponseEntity.ok(asPaging);
    }

    @GetMapping(value = "/get")
    public ResponseEntity<Object> getMessage(@RequestParam String id) {

        var messageResponseDTO = messageService.getBy(id);

        return ResponseEntity.ok(messageResponseDTO);
    }

}
