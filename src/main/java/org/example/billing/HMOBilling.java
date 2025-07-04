package org.example.billing;

import org.example.model.BillingStrategy;

public class HMOBilling implements BillingStrategy {
    @Override
    public double applyDiscount(double bill) {
        return bill * 0.8;
    } // 20% discount
}
