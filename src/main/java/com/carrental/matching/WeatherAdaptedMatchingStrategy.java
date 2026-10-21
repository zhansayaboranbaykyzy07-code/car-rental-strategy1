package com.carrental.matching;

import java.util.List;

public class WeatherAdaptedMatchingStrategy implements CarMatchingStrategy {
    private final WeatherDataService weatherDataService;
    private final String currentCity;

    public WeatherAdaptedMatchingStrategy(WeatherDataService weatherDataService, String currentCity) {
        if (weatherDataService == null) {
            throw new IllegalArgumentException("WeatherDataService cannot be null");
        }
        this.weatherDataService = weatherDataService;
        this.currentCity = currentCity;
    }

    @Override
    public CarInfo selectCar(DriverProfile driver, List<CarInfo> availableCars) {
        if (availableCars == null || availableCars.isEmpty()) {
            throw new IllegalArgumentException("Available cars list cannot be empty");
        }
        String weather = weatherDataService.getCurrentWeatherCondition(currentCity);

        if ("SNOW".equalsIgnoreCase(weather) || "RAIN".equalsIgnoreCase(weather)) {
            return availableCars.stream()
                    .filter(CarInfo::isAwd)
                    .findFirst()
                    .orElse(availableCars.get(0));
        }
        return availableCars.get(0);
    }
}