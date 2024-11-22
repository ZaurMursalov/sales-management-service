package com.example.mstapaz.service;

import com.example.mstapaz.model.dto.MessageDto;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@Slf4j
public class MessageService {

    @SneakyThrows
    public MessageDto getMessages(){
        Thread.sleep(new Random().nextInt(1000));
        return new MessageDto("Hello TapAz");
    }

    @SneakyThrows
    public MessageDto messageDto1(String lang){

        Thread.sleep(new Random().nextInt(10000));

        return new MessageDto(lang);

    }
}
