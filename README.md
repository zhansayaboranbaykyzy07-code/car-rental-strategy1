# Assignment 5: Strategy Pattern Implementation (Car Rental System)

## 1. Class Responsibility Table (SRP Validation)

> **Constraint Compliance:** Each description contains exactly one sentence, under 25 words, strictly omitting forbidden words ("if", "and", "or", "but").

| Class Name | Package | Single Responsibility Description (SRP) | Word Count |
| :--- | :--- | :--- | :--- |
| `RentalRequest` | `com.carrental.pricing.bad` | Holds customer rental duration pricing criteria details. | 7 words |
| `BadPricingCalculator` | `com.carrental.pricing.bad` | Computes rental prices using monolithic decision structures. | 7 words |
| `PricingStrategy` | `com.carrental.pricing` | Defines contract for pricing calculation algorithms. | 6 words |
| `StandardPricingStrategy` | `com.carrental.pricing` | Calculates standard daily rental prices without discounts. | 7 words |
| `WeekendSurgePricingStrategy` | `com.carrental.pricing` | Applies peak weekend surge multipliers to base pricing. | 8 words |
| `LoyaltyTierPricingStrategy` | `com.carrental.pricing` | Computes price reductions based on customer tier. | 7 words |
| `PricingContext` | `com.carrental.pricing` | Delegates total price calculations to active strategy. | 7 words |
| `PricingStrategySelector` | `com.carrental.pricing` | Selects appropriate pricing strategy matching request attributes. | 7 words |
| `DriverProfile` | `com.carrental.matching` | Encapsulates driver experience level eco preferences. | 7 words |
| `CarInfo` | `com.carrental.matching` | Stores vehicle specifications price features. | 6 words |
| `WeatherDataService` | `com.carrental.matching` | Defines contract for external weather condition providers. | 7 words |
| `CarMatchingStrategy` | `com.carrental.matching` | Defines contract for vehicle selection algorithms. | 6 words |
| `EconomyMatchingStrategy` | `com.carrental.matching` | Selects most cost effective low consumption vehicles. | 7 words |
| `EcoGreenMatchingStrategy` | `com.carrental.matching` | Filters hybrid electric vehicles for environmentally conscious drivers. | 8 words |
| `WeatherAdaptedMatchingStrategy` | `com.carrental.matching` | Recommends all wheel drive vehicles during severe weather. | 8 words |
| `CarMatchingContext` | `com.carrental.matching` | Delegates vehicle selection to currently configured strategy. | 7 words |
| `CarMatchingSelector` | `com.carrental.matching` | Chooses optimal car matching strategy based on weather. | 8 words |

---

## 2. Theoretical Reflection: Strategy vs. State vs. Template Method

### Why this solution is Strategy
The Strategy pattern was chosen because our goal is to provide **interchangeable algorithms** (`Pricing` and `CarMatching`) that can be dynamically swapped at runtime depending on external conditions (such as customer loyalty status, weekend demand, or snow weather).

* **Strategy vs. State Pattern:**
  While both patterns rely on composition and delegate work to dynamic objects, their intent differs fundamentally. The **State pattern** represents state-dependent behavior where state transitions are managed internally by state objects, altering context behavior as state changes. In our implementation, `PricingContext` and `CarMatchingContext` do not transition between internal states; they execute standalone calculation algorithms configured externally by a `Selector` or client code.

* **Strategy vs. Template Method Pattern:**
  The **Template Method pattern** relies on class inheritance to define an algorithm's skeleton in a parent class, deferring specific steps to subclasses. This creates tight coupling and static compile-time binding. In contrast, the **Strategy pattern** utilizes object composition and interfaces, enabling dynamic runtime switching of completely independent algorithms without subclassing context objects.

---

## 3. Git Refactoring Commit History

* **Before Refactoring (Monolithic Switch/If Implementation):**
  `Commit: Initial commit: Monolithic BadPricingCalculator with switch/if-else`
* **After Refactoring (Clean Strategy Pattern Implementation):**
  `Commit: Refactored Pricing into Strategy Pattern: interfaces, strategies, context, selector`

---

## 4. Execution & Testing Instructions

1. **Run Unit & Parameterized Tests:**
   Execute `PricingStrategyTest.java` and `CarMatchingStrategyTest.java` using JUnit 5 runner.
2. **Run Demonstration Application:**
   Execute `MainConsoleApp.java` to observe strategy swapping at runtime and automatic selection by `Selector` classes.