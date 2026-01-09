package com.company.vehicles.spring.service;

import java.util.List;

import com.company.vehicles.spring.dto.OperationResponseDto;
import com.company.vehicles.spring.dto.VehicleResponseDto;
import com.company.vehicles.spring.dto.VehicleStockRequestDto;
import com.company.vehicles.spring.entity.Vehicle;
import com.company.vehicles.spring.exception.VehicleAlreadyDeletedException;
import com.company.vehicles.spring.exception.VehicleNotFoundException;
import com.company.vehicles.spring.mapper.VehicleMapper;
import com.company.vehicles.spring.repository.VehicleRepository;

public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository repository;
    private final VehicleMapper mapper;

    public VehicleServiceImpl(VehicleRepository repository, VehicleMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<VehicleResponseDto> getAllActive() {
        return repository.findByDeleted("N")
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public List<VehicleResponseDto> getLowStockExpensive() {
        return repository.findLowStockExpensive()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public OperationResponseDto deleteByModel(String model) {
        Vehicle vehicle = repository.findByModel(model)
                .orElseThrow(() -> new VehicleNotFoundException("Vehicle not found"));

        if ("S".equals(vehicle.getDeleted())) {
            throw new VehicleAlreadyDeletedException("Vehicle already deleted");
        }

        vehicle.setDeleted("S");
        return new OperationResponseDto("Vehicle deleted successfully");
    }

    @Override
    public VehicleResponseDto updateStock(VehicleStockRequestDto dto) {
        Vehicle vehicle = repository.findById(dto.getId())
                .orElseThrow(() -> new VehicleNotFoundException("Vehicle not found"));

        vehicle.setStock(dto.getStock());
        return mapper.toDto(vehicle);
    }
}
