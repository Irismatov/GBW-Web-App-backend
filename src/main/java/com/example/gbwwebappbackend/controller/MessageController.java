package com.example.gbwwebappbackend.controller;


import com.example.gbwwebappbackend.domain.request.MessageRequestDTO;
import com.example.gbwwebappbackend.domain.response.MessageResponseDTO;
import com.example.gbwwebappbackend.service.message.MessageService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/contact/message")
public class MessageController {
    private final MessageService messageService;

    @PostMapping
    public ResponseEntity<MessageResponseDTO> sendMessage(@RequestBody MessageRequestDTO message) {
        return ResponseEntity.ok(messageService.save(message));
    }

    @GetMapping(value = "/get/custom")
    public ResponseEntity<Object> getMessage(@RequestParam int page, @RequestParam int size) {

        List<MessageResponseDTO> asPaging = messageService.getAsPaging(page, size);

        return ResponseEntity.ok(asPaging);
    }

    @GetMapping(value = "/get")
    public ResponseEntity<Object> getMessage(@RequestParam String id) {

        var messageResponseDTO = messageService.getBy(id);

        return ResponseEntity.ok(messageResponseDTO);
    }

}
