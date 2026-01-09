package com.company.vehicles.spring.dto;

public class OperationResponseDto {

    private String message;

    public OperationResponseDto(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
