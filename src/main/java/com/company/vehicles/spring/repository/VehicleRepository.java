package com.company.vehicles.spring.repository;

import com.company.vehicles.spring.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    List<Vehicle> findByDeleted(String deleted);

    Optional<Vehicle> findByModel(String model);

    @Query("""
                SELECT v FROM Vehicle v
                WHERE v.deleted = 'N'
                  AND v.price > 20000
                  AND v.stock < 10
            """)
    List<Vehicle> findLowStockExpensive();
}
