package com.carrental.matching;

import java.util.List;

public interface CarMatchingStrategy {
    CarInfo selectCar(DriverProfile driver, List<CarInfo> availableCars);
}