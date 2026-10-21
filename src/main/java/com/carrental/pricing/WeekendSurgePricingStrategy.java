package com.carrental.pricing;

import com.carrental.pricing.bad.RentalRequest;

public class WeekendSurgePricingStrategy implements PricingStrategy {
    @Override
    public double calculateTotal(RentalRequest request) {
        if (request == null) {
            throw new IllegalArgumentException("Rental request cannot be null");
        }
        double surgeRate = request.isWeekend() ? 1.3 : 1.0;
        double subtotal = request.getBaseDailyRate() * surgeRate * request.getDays();
        if (request.getDays() >= 7) {
            subtotal *= 0.9;
        }
        return subtotal;
    }
}