package org.example;

import org.example.billing.CashBilling;
import org.example.billing.HMOBilling;
import org.example.billing.SeniorBilling;
import org.example.model.BillingStrategy;
import org.example.model.Patient;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BillingStrategyTest {
    private static final double DELTA = 0.001;

    @Test
    void shouldSuccessfullySetHMOBilling() {
        BillingStrategy hmo = new HMOBilling();
        assertEquals(800.0, hmo.applyDiscount(1000), DELTA);
        assertEquals(0.0, hmo.applyDiscount((0)), DELTA);
        assertEquals(-400.0, hmo.applyDiscount(-500), DELTA);
    }

    @Test
    void shouldSuccessfullySetSeniorBilling() {
        BillingStrategy senior = new SeniorBilling();
        assertEquals(700.0, senior.applyDiscount(1000), DELTA);
        assertEquals(0.0, senior.applyDiscount((0)), DELTA);
        assertEquals(-70.0, senior.applyDiscount(-100), DELTA);
    }

    @Test
    void shouldSuccessfullySetCashBilling() {
        BillingStrategy cash = new CashBilling();
        assertEquals(1000.0, cash.applyDiscount(1000), DELTA);
        assertEquals(0.0, cash.applyDiscount((0)), DELTA);
        assertEquals(-250.0, cash.applyDiscount(-250), DELTA);
    }

    @Test
    void shouldSuccessfullyGenerateBillWithHMOBilling() {
        Patient testPatient = new Patient("Alice", "H001");
        testPatient.addBill(1000);
        testPatient.setBillingStrategy(new HMOBilling());
        testPatient.generateBill();
        assertEquals(800.0, testPatient.getBill(), DELTA);
    }

    @Test
    void shouldSuccessfullyGenerateBillWithSeniorBilling() {
        Patient testPatient = new Patient("Bob", "S001");
        testPatient.addBill(2000);
        testPatient.setBillingStrategy(new SeniorBilling());
        testPatient.generateBill();
        assertEquals(1400.0, testPatient.getBill(), DELTA);
    }

    @Test
    void shouldSuccessfullyGenerateBillWithCashBilling() {
        Patient testPatient = new Patient("Charlie", "C001");
        testPatient.addBill(1500);
        testPatient.setBillingStrategy(new CashBilling());
        testPatient.generateBill();
        assertEquals(1500.0, testPatient.getBill(), DELTA);
    }

    @Test
    void shouldSuccessfullyGenerateBillWithDefaultStrategy() {
        Patient testPatient = new Patient("Default", "D001");
        testPatient.addBill(1000);
        testPatient.generateBill();
        assertEquals(1000.0, testPatient.getBill(), DELTA);
    }

    @Test
    void shouldSuccessfullyGenerateBillWithZeroBill() {
        Patient testPatient = new Patient("Zero", "Z001");
        testPatient.setBillingStrategy(new CashBilling());
        testPatient.generateBill();
        assertEquals(0.0, testPatient.getBill(), DELTA);
    }

    @Test
    void shouldSuccessfullyGenerateBillWithNegativeBill() {
        Patient testPatient = new Patient("Negative", "N001");
        testPatient.addBill(-1000);
        testPatient.setBillingStrategy(new CashBilling());
        testPatient.generateBill();
        assertEquals(-1000.0, testPatient.getBill(), DELTA);
    }
}