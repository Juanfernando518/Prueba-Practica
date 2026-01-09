package com.company.vehicles.spring.service;

import com.company.vehicles.spring.dto.OperationResponseDto;
import com.company.vehicles.spring.dto.VehicleResponseDto;
import com.company.vehicles.spring.dto.VehicleStockRequestDto;

import java.util.List;

public interface VehicleService {

    List<VehicleResponseDto> getAllActive();

    List<VehicleResponseDto> getLowStockExpensive();

    OperationResponseDto deleteByModel(String model);

    VehicleResponseDto updateStock(VehicleStockRequestDto dto);
}
