package com.example.mstapaz.exception;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.example.mstapaz.exception.ExceptionConstant.*;

@Slf4j
@RestControllerAdvice
public class ErrorHandler {
//
//    @ExceptionHandler(Exception.class)
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    public ExceptionResponse handle(Exception ex) {
//
//        log.error("ActionLog.started.handle, ex:{}", ex);
//
//        return new ExceptionResponse(EXCEPTION_CODE, EXCEPTION_MESSAGE);
//    }
@ExceptionHandler(NotFound.class)
@ResponseStatus(HttpStatus.NOT_FOUND)
public ExceptionResponse notFoundHandle(NotFound ex, HttpServletRequest request) {
    return new ExceptionResponse(
            HttpStatus.NOT_FOUND.value(),
            "Not Found",
            ex.getMessage(),          // Mesaj burada geri qaytarılır
            request.getRequestURI()
    );
}
}
