package com.carrental.pricing.bad;

public class RentalRequest {
    private final double baseDailyRate;
    private final int days;
    private final boolean isWeekend;
    private final String customerTier; // "REGULAR", "GOLD", "VIP"

    public RentalRequest(double baseDailyRate, int days, boolean isWeekend, String customerTier) {
        this.baseDailyRate = baseDailyRate;
        this.days = days;
        this.isWeekend = isWeekend;
        this.customerTier = customerTier;
    }

    public double getBaseDailyRate() { return baseDailyRate; }
    public int getDays() { return days; }
    public boolean isWeekend() { return isWeekend; }
    public String getCustomerTier() { return customerTier; }
}