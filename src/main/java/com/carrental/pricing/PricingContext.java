package com.carrental.pricing;

import com.carrental.pricing.bad.RentalRequest;

public class PricingContext {
    private PricingStrategy strategy;

    public PricingContext(PricingStrategy strategy) {
        if (strategy == null) {
            throw new IllegalArgumentException("Initial strategy cannot be null");
        }
        this.strategy = strategy;
    }

    public void setStrategy(PricingStrategy strategy) {
        if (strategy == null) {
            throw new IllegalArgumentException("Strategy cannot be null");
        }
        this.strategy = strategy;
    }

    public double executePricing(RentalRequest request) {
        return strategy.calculateTotal(request);
    }
}