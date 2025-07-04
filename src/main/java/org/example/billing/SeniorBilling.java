package org.example.billing;

import org.example.model.BillingStrategy;

public class SeniorBilling implements BillingStrategy {
    @Override
    public double applyDiscount(double bill) {
        return bill * 0.7;
    } // 30% discount
}
