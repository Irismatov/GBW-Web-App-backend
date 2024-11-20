package com.example.gbwwebappbackend.controller;

import com.example.gbwwebappbackend.service.newsletter.NewsLetterService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping("/news-letter")
public class EmailNewsLetterController {

    private final NewsLetterService newsLetterService;

    public EmailNewsLetterController( NewsLetterService newsLetterService) {
        this.newsLetterService = newsLetterService;
    }


    @CrossOrigin
    @RequestMapping(value = "/register", method = RequestMethod.PUT)
    ResponseEntity<Object> registration(@RequestParam String email){

        newsLetterService.save(email);

        return ResponseEntity.ok().build();

    }

}
