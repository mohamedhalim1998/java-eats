package com.mohamed.halim.javaeats.contoller;

import com.mohamed.halim.javaeats.dto.response.ExceptionResponse;
import com.mohamed.halim.javaeats.exceptions.EmailAlreadyExistException;
import com.mohamed.halim.javaeats.exceptions.UserAlreadyExistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {UserAlreadyExistException.class, EmailAlreadyExistException.class})
    public ResponseEntity<ExceptionResponse> handeException(RuntimeException ex) {
        return ResponseEntity.badRequest().body(
                ExceptionResponse.builder()
                        .httpStatus(HttpStatus.BAD_REQUEST)
                        .msg(ex.getMessage())
                        .statusCode(HttpStatus.BAD_REQUEST.value())
                        .build()
        );
    }
}
