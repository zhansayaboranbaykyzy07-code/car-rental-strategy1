package com.carrental.pricing.bad;

public class BadPricingCalculator {

    public double calculatePrice(String pricingType, RentalRequest request) {
        if (pricingType == null) {
            throw new IllegalArgumentException("Pricing type cannot be null");
        }

        switch (pricingType.toUpperCase()) {
            case "STANDARD":
                return request.getBaseDailyRate() * request.getDays();

            case "WEEKEND_SURGE":
                double surgeRate = request.isWeekend() ? 1.3 : 1.0;
                double subtotal = request.getBaseDailyRate() * surgeRate * request.getDays();
                if (request.getDays() >= 7) {
                    subtotal *= 0.9;
                }
                return subtotal;

            case "LOYALTY_TIER":
                double basePrice = request.getBaseDailyRate() * request.getDays();
                if ("VIP".equalsIgnoreCase(request.getCustomerTier())) {
                    return basePrice * 0.75;
                } else if ("GOLD".equalsIgnoreCase(request.getCustomerTier())) {
                    return basePrice * 0.85;
                } else {
                    return basePrice;
                }

            default:
                throw new IllegalArgumentException("Unknown pricing type: " + pricingType);
        }
    }
}