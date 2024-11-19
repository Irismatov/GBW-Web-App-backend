package com.example.gbwwebappbackend.controller;


import com.example.gbwwebappbackend.domain.request.MessageRequestDTO;
import com.example.gbwwebappbackend.domain.response.MessageResponseDTO;
import com.example.gbwwebappbackend.service.MessageService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/contact")
public class MessageController {
    private final MessageService messageService;

    @CrossOrigin
    @PostMapping(value = "message")
    public ResponseEntity<MessageResponseDTO> sendMessage(@RequestBody MessageRequestDTO message) {
        return ResponseEntity.ok(messageService.save(message));
    }
}
