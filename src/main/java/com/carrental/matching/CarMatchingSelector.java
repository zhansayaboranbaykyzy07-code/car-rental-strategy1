package com.carrental.matching;

public class CarMatchingSelector {
    private final WeatherDataService weatherDataService;

    // Конструктор без параметров
    public CarMatchingSelector() {
        this.weatherDataService = null;
    }

    // Конструктор с сервисом погоды
    public CarMatchingSelector(WeatherDataService weatherDataService) {
        this.weatherDataService = weatherDataService;
    }

    public CarMatchingStrategy selectStrategy(DriverProfile driver, String city) {
        if (driver == null) {
            throw new IllegalArgumentException("Driver profile cannot be null");
        }

        String weather = (weatherDataService != null && city != null)
                ? weatherDataService.getCurrentWeatherCondition(city)
                : "SUNNY";

        if ("SNOW".equalsIgnoreCase(weather) || "RAIN".equalsIgnoreCase(weather)) {
            return new WeatherAdaptedMatchingStrategy(weatherDataService, city);
        } else if (driver.isPrefersEco()) {
            return new EcoGreenMatchingStrategy();
        } else {
            return new EconomyMatchingStrategy();
        }
    }
}