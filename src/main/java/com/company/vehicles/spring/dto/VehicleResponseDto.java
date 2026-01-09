package com.company.vehicles.spring.dto;

public class VehicleResponseDto {
    private Long id;
    private String brand;
    private String model;
    private Double price;
    private Integer stock;

    public VehicleResponseDto() {
    }

    public VehicleResponseDto(Long id, String brand, String model, Double price, Integer stock) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.stock = stock;
    }

    public Long getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getStock() {
        return stock;
    }
}
