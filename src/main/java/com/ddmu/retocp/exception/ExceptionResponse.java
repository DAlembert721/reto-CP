package com.ddmu.retocp.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
public class ExceptionResponse {
    private LocalDateTime date;

    private String message;

    private String details;

}
