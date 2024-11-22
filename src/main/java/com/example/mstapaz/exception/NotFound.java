package com.example.mstapaz.exception;

import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFound extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public NotFound(String message) {
        super(message);
    }

}
