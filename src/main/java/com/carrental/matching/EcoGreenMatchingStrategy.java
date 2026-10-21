package com.carrental.matching;

import java.util.List;

public class EcoGreenMatchingStrategy implements CarMatchingStrategy {
    @Override
    public CarInfo selectCar(DriverProfile driver, List<CarInfo> availableCars) {
        if (availableCars == null || availableCars.isEmpty()) {
            throw new IllegalArgumentException("Available cars list cannot be empty");
        }
        return availableCars.stream()
                .filter(CarInfo::isElectricOrHybrid)
                .findFirst()
                .orElse(availableCars.get(0));
    }
}