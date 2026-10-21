package com.carrental;

import com.carrental.pricing.*;
import com.carrental.pricing.bad.RentalRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class PricingStrategyTest {

    @Test
    void testStandardPricingStrategy() {
        PricingStrategy strategy = new StandardPricingStrategy();
        RentalRequest request = new RentalRequest(100.0, 3, false, "REGULAR");
        assertEquals(300.0, strategy.calculateTotal(request));
    }

    @Test
    void testWeekendSurgePricingStrategy() {
        PricingStrategy strategy = new WeekendSurgePricingStrategy();
        RentalRequest request = new RentalRequest(100.0, 2, true, "REGULAR");
        assertEquals(260.0, strategy.calculateTotal(request));
    }

    @Test
    void testLoyaltyTierPricingStrategyVip() {
        PricingStrategy strategy = new LoyaltyTierPricingStrategy();
        RentalRequest request = new RentalRequest(100.0, 4, false, "VIP");
        assertEquals(300.0, strategy.calculateTotal(request));
    }

    @Test
    void testPricingSelectorRules() {
        PricingStrategySelector selector = new PricingStrategySelector();

        RentalRequest vipReq = new RentalRequest(100.0, 2, false, "VIP");
        assertTrue(selector.selectStrategy(vipReq) instanceof LoyaltyTierPricingStrategy);

        RentalRequest weekendReq = new RentalRequest(100.0, 2, true, "REGULAR");
        assertTrue(selector.selectStrategy(weekendReq) instanceof WeekendSurgePricingStrategy);

        RentalRequest standardReq = new RentalRequest(100.0, 2, false, "REGULAR");
        assertTrue(selector.selectStrategy(standardReq) instanceof StandardPricingStrategy);
    }

    // Required @ParameterizedTest: verifies price is never negative across all strategies
    @ParameterizedTest
    @MethodSource("provideStrategies")
    void testPriceIsNeverNegative(PricingStrategy strategy) {
        RentalRequest request = new RentalRequest(50.0, 5, false, "REGULAR");
        assertTrue(strategy.calculateTotal(request) >= 0);
    }

    static Stream<PricingStrategy> provideStrategies() {
        return Stream.of(
                new StandardPricingStrategy(),
                new WeekendSurgePricingStrategy(),
                new LoyaltyTierPricingStrategy()
        );
    }
}