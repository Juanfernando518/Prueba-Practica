package com.company.vehicles.spring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.company.vehicles.spring.dto.OperationResponseDto;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(VehicleNotFoundException.class)
    public OperationResponseDto handleNotFound(VehicleNotFoundException ex) {
        throw new org.springframework.web.server.ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.getMessage());
    }

    @ExceptionHandler(VehicleAlreadyDeletedException.class)
    public OperationResponseDto handleConflict(VehicleAlreadyDeletedException ex) {
        throw new org.springframework.web.server.ResponseStatusException(
                HttpStatus.CONFLICT, ex.getMessage());
    }

}
