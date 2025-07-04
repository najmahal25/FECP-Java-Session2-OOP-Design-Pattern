package org.example;

public class HMOBilling implements BillingStrategy {
    @Override
    public double applyDiscount(double bill) {
        return bill * 0.8;
    } // 20% discount
}
