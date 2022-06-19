package com.ddmu.retocp.exception;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@ControllerAdvice
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionResponse> manageAllExceptions(Exception exception, WebRequest request){
        ExceptionResponse response = new ExceptionResponse(LocalDateTime.now(), exception.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
                                                                  HttpStatus status, WebRequest request) {
        String message = ex.getBindingResult().getAllErrors().stream().map(e ->
                e.getDefaultMessage().toString().concat(", ")).collect(Collectors.joining());
        ExceptionResponse response = new ExceptionResponse(LocalDateTime.now(), message, request.getDescription(false));
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(ModelNotFoundException.class)
    public ResponseEntity<ExceptionResponse> manageModelNotFoundException(ModelNotFoundException exception, WebRequest request){
        ExceptionResponse response = new ExceptionResponse(LocalDateTime.now(), exception.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(DuplicateKeyException.class)
    public final ResponseEntity<ExceptionResponse> manageDuplicateKeyExceptions(DuplicateKeyException exception, WebRequest request){
        ExceptionResponse response = new ExceptionResponse(LocalDateTime.now(), exception.getCause().getMessage().split("27017. ")[1], request.getDescription(false));
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
