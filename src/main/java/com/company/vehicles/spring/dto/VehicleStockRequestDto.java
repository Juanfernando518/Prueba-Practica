package com.company.vehicles.spring.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class VehicleStockRequestDto {

    @NotNull
    private Long id;

    @NotNull
    @Min(0)
    private Integer stock;

    public Long getId() {
        return id;
    }

    public Integer getStock() {
        return stock;
    }

}
