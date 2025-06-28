package com.example.mstapaz.exception;

import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@Getter
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFound extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public NotFound(String message) {
        super(message);
    }

}
