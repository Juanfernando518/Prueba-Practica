package com.company.vehicles.spring.exception;

public class VehicleAlreadyDeletedException extends RuntimeException {

    public VehicleAlreadyDeletedException(String message) {
        super(message);
    }
}
