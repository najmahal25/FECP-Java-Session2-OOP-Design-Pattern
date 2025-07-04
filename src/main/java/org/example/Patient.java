package org.example;

public class Patient {
    private String name;
    private String patientID;
    private double bill;
    private BillingStrategy billingStrategy;

    public Patient(String name, String patientID) {
        this.name = name;
        this.patientID = patientID;
        this.bill = 0;
        this.billingStrategy = new CashBilling(); // default
    }

    // Getters and setters for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getters and setters for PID
    public String getPatientID() {
        return patientID;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    // Getters and setters for billing
    public double getBill() {
        return bill;
    }

    public void addBill(double bill) {
        this.bill += bill;
    }

    // getters and setters for billing strategy
    public BillingStrategy getBillingStrategy() { return billingStrategy; };

    public void setBillingStrategy(BillingStrategy billingStrategy) { this.billingStrategy = billingStrategy; };

    public void generateBill() {
        System.out.printf("Original cost: %.2f", bill);
        double discountedBill = billingStrategy.applyDiscount(bill);
        this.bill = discountedBill;
        System.out.printf("Discounted cost: %.2f", discountedBill);
    }
}
