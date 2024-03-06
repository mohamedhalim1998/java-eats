package com.mohamed.halim.javaeats.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ExceptionResponse {
    private HttpStatus httpStatus;
    private int statusCode;
    private String msg;
}
