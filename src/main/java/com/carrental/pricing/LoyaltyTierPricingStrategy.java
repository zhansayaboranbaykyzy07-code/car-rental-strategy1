package com.carrental.pricing;

import com.carrental.pricing.bad.RentalRequest;

public class LoyaltyTierPricingStrategy implements PricingStrategy {
    @Override
    public double calculateTotal(RentalRequest request) {
        if (request == null) {
            throw new IllegalArgumentException("Rental request cannot be null");
        }
        double basePrice = request.getBaseDailyRate() * request.getDays();
        if ("VIP".equalsIgnoreCase(request.getCustomerTier())) {
            return basePrice * 0.75;
        } else if ("GOLD".equalsIgnoreCase(request.getCustomerTier())) {
            return basePrice * 0.85;
        } else {
            return basePrice;
        }
    }
}