package com.carrental.pricing;

import com.carrental.pricing.bad.RentalRequest;

public class PricingStrategySelector {

    public PricingStrategy selectStrategy(RentalRequest request) {
        if (request == null) {
            throw new IllegalArgumentException("Request cannot be null");
        }

        if ("VIP".equalsIgnoreCase(request.getCustomerTier()) || "GOLD".equalsIgnoreCase(request.getCustomerTier())) {
            return new LoyaltyTierPricingStrategy();
        } else if (request.isWeekend()) {
            return new WeekendSurgePricingStrategy();
        } else {
            return new StandardPricingStrategy();
        }
    }
}