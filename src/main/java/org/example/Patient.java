package org.example;

public class Patient {
    private String name;
    private String patientID;
    private double bill;

    public Patient(String name, String patientID) {
        this.name = name;
        this.patientID = patientID;
        this.bill = 0;
    }

    // Getters and setters for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getters and setters of PID
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
}
