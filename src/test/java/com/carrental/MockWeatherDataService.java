package com.carrental;

import com.carrental.matching.WeatherDataService;

public class MockWeatherDataService implements WeatherDataService {
    private String mockWeather;

    public MockWeatherDataService(String mockWeather) {
        this.mockWeather = mockWeather;
    }

    public void setMockWeather(String mockWeather) {
        this.mockWeather = mockWeather;
    }

    @Override
    public String getCurrentWeatherCondition(String city) {
        return mockWeather;
    }
}