package com.carrental.matching;

public class CarInfo {
    private final String model;
    private final double fuelConsumption;
    private final boolean isAwd;
    private final boolean isElectricOrHybrid;
    private final double dailyPrice;

    public CarInfo(String model, double fuelConsumption, boolean isAwd, boolean isElectricOrHybrid, double dailyPrice) {
        this.model = model;
        this.fuelConsumption = fuelConsumption;
        this.isAwd = isAwd;
        this.isElectricOrHybrid = isElectricOrHybrid;
        this.dailyPrice = dailyPrice;
    }

    public String getModel() { return model; }
    public double getFuelConsumption() { return fuelConsumption; }
    public boolean isAwd() { return isAwd; }
    public boolean isElectricOrHybrid() { return isElectricOrHybrid; }
    public double getDailyPrice() { return dailyPrice; }
}