package com.example.mstapaz.controller;

import com.example.mstapaz.model.dto.MessageDto;
import com.example.mstapaz.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/messages")
public class MessageController {
    private final MessageService messageService;


    @GetMapping
    public MessageDto getMessage(){
        return messageService.getMessages();
    }

    @GetMapping("/2")
    public MessageDto getMessage1(){
        return messageService.messageDto1("England");
    }

}
