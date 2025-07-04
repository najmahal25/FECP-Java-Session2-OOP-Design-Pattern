package org.example;

public class SeniorBilling implements BillingStrategy {
    @Override
    public double applyDiscount(double bill) {
        return bill * 0.7;
    } // 30% discount
}
