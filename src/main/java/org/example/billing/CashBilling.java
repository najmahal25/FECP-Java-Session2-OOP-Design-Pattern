package org.example.billing;

import org.example.model.BillingStrategy;

public class CashBilling implements BillingStrategy {
    @Override
    public double applyDiscount(double bill) {
        return bill;
    } // no discount
}
