package com.company.vehicles.spring.mapper;

import com.company.vehicles.spring.dto.VehicleResponseDto;
import com.company.vehicles.spring.entity.Vehicle;

public class VehicleMapper {

    public VehicleResponseDto toDto(Vehicle vehicle) {
        return new VehicleResponseDto(
                vehicle.getId(),
                vehicle.getBrand(),
                vehicle.getModel(),
                vehicle.getPrice(),
                vehicle.getStock());
    }
}
