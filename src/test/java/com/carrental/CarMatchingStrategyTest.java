package com.carrental;

import com.carrental.matching.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CarMatchingStrategyTest {

    private List<CarInfo> cars;
    private DriverProfile driverEco;
    private DriverProfile driverStandard;

    @BeforeEach
    void setUp() {
        cars = List.of(
                new CarInfo("Toyota Prius", 4.2, false, true, 50.0),
                new CarInfo("Subaru Outback AWD", 8.5, true, false, 80.0),
                new CarInfo("Hyundai Accent", 6.0, false, false, 35.0)
        );
        driverEco = new DriverProfile("Alice", 5, true);
        driverStandard = new DriverProfile("Bob", 3, false);
    }

    @Test
    void testEconomyMatchingStrategy() {
        CarMatchingStrategy strategy = new EconomyMatchingStrategy();
        CarInfo chosen = strategy.selectCar(driverStandard, cars);
        assertEquals("Hyundai Accent", chosen.getModel());
    }

    @Test
    void testEcoGreenMatchingStrategy() {
        CarMatchingStrategy strategy = new EcoGreenMatchingStrategy();
        CarInfo chosen = strategy.selectCar(driverEco, cars);
        assertEquals("Toyota Prius", chosen.getModel());
    }

    @Test
    void testWeatherAdaptedMatchingStrategySnow() {
        MockWeatherDataService weatherService = new MockWeatherDataService("SNOW");
        CarMatchingStrategy strategy = new WeatherAdaptedMatchingStrategy(weatherService, "Astana");

        CarInfo chosen = strategy.selectCar(driverStandard, cars);
        assertEquals("Subaru Outback AWD", chosen.getModel());
    }

    @Test
    void testCarMatchingSelectorRules() {
        MockWeatherDataService weatherService = new MockWeatherDataService("SNOW");
        CarMatchingSelector selector = new CarMatchingSelector(weatherService);

        CarMatchingStrategy snowStrategy = selector.selectStrategy(driverStandard, "Astana");
        assertTrue(snowStrategy instanceof WeatherAdaptedMatchingStrategy);

        weatherService.setMockWeather("SUNNY");
        CarMatchingStrategy ecoStrategy = selector.selectStrategy(driverEco, "Astana");
        assertTrue(ecoStrategy instanceof EcoGreenMatchingStrategy);
    }
}