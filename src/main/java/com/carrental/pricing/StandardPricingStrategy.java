package com.carrental.pricing;

import com.carrental.pricing.bad.RentalRequest;

public class StandardPricingStrategy implements PricingStrategy {
    @Override
    public double calculateTotal(RentalRequest request) {
        if (request == null) {
            throw new IllegalArgumentException("Rental request cannot be null");
        }
        return request.getBaseDailyRate() * request.getDays();
    }
}