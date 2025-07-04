package org.example;

import java.util.Scanner;

public class Main {
    private static void displayMenu() {
        System.out.println("=== Hospital Billing System ===");
        System.out.println("1. Register Patient");
        System.out.println("2. Add Service");
        System.out.println("3. Compute Bill");
        System.out.println("4. Exit");
    }

    private static Patient registerPatient(String name, String patientID) {
        return new Patient(name, patientID);
    }

    private static void addService(Patient patient) {
        if (patient == null) {
            System.out.println("Register a patient first.");
            return;
        }

        // patient.addBill(double bill) to add service billing
    }

    private static void computeBill(Patient patient) {
        if (patient == null) {
            System.out.println("Register a patient first.");
            return;
        }

        // patient.getBill() to get service billing
    }

    public static void main(String[] args) {
        // Initialize variables
        Scanner scanner = new Scanner(System.in);
        Patient patient = null;
        int choice = 0;

        displayMenu();

        while (choice != 4) {
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Patient Name: ");
                    String newPatientName = scanner.nextLine();

                    System.out.print("Enter Patient ID: ");
                    String newPatientID = scanner.nextLine();

                    patient = registerPatient(newPatientName, newPatientID);
                    System.out.println("Patient Registered!");
                    break;
                case 2:
                    addService(patient);
                    break;
                case 3:
                    computeBill();
                    break;
                case 4:
                    System.out.println("Thank you for using this system.");
                    break;
                default:
                    System.out.println("Invalid input.");
                    break;
            }

            System.out.println();
        }
    }
}