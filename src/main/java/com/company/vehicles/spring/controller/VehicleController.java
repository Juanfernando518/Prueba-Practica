package com.company.vehicles.spring.controller;

import com.company.vehicles.spring.dto.*;
import com.company.vehicles.spring.service.VehicleService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {

    private final VehicleService service;

    public VehicleController(VehicleService service) {
        this.service = service;
    }

    @GetMapping
    public List<VehicleResponseDto> getAll() {
        return service.getAllActive();
    }

    @GetMapping("/low-stock-expensive")
    public List<VehicleResponseDto> getLowStockExpensive() {
        return service.getLowStockExpensive();
    }

    @PatchMapping("/delete/{model}")
    public OperationResponseDto delete(@PathVariable String model) {
        return service.deleteByModel(model);
    }

    @PatchMapping("/stock")
    public VehicleResponseDto updateStock(@RequestBody @Valid VehicleStockRequestDto dto) {
        return service.updateStock(dto);
    }
}
