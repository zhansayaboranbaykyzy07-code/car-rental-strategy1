package com.carrental.matching;

import java.util.Comparator;
import java.util.List;

public class EconomyMatchingStrategy implements CarMatchingStrategy {
    @Override
    public CarInfo selectCar(DriverProfile driver, List<CarInfo> availableCars) {
        if (availableCars == null || availableCars.isEmpty()) {
            throw new IllegalArgumentException("Available cars list cannot be empty");
        }
        return availableCars.stream()
                .min(Comparator.comparingDouble(CarInfo::getDailyPrice)
                        .thenComparingDouble(CarInfo::getFuelConsumption))
                .orElse(availableCars.get(0));
    }
}