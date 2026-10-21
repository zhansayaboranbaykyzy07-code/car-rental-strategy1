package com.carrental.pricing;

import com.carrental.pricing.bad.RentalRequest;

public interface PricingStrategy {
    double calculateTotal(RentalRequest request);
}