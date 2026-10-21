package com.carrental.matching;

import java.util.List;

public class CarMatchingContext {
    private CarMatchingStrategy strategy;

    public CarMatchingContext(CarMatchingStrategy strategy) {
        if (strategy == null) {
            throw new IllegalArgumentException("Initial strategy cannot be null");
        }
        this.strategy = strategy;
    }

    public void setStrategy(CarMatchingStrategy strategy) {
        if (strategy == null) {
            throw new IllegalArgumentException("Strategy cannot be null");
        }
        this.strategy = strategy;
    }

    public CarInfo executeMatching(DriverProfile driver, List<CarInfo> cars) {
        return strategy.selectCar(driver, cars);
    }
}