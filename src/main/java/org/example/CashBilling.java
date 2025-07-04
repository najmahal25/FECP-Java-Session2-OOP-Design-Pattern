package org.example;

public class CashBilling implements BillingStrategy {
    @Override
    public double applyDiscount(double bill) {
        return bill;
    } // no discount
}
