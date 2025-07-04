package org.example;

import org.example.billing.CashBilling;
import org.example.billing.HMOBilling;
import org.example.billing.SeniorBilling;
import org.example.model.Patient;
import org.example.model.Service;
import org.example.service.ServiceFactory;

import java.util.Scanner;

public class Main {
    private static void displayMenu() {
        System.out.println("=== Hospital Billing System ===");
        System.out.println("1. Register Patient");
        System.out.println("2. Add Service");
        System.out.println("3. Compute Bill");
        System.out.println("4. Exit");
    }

    private static Patient registerPatient() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Patient Name: ");
        String newPatientName = scanner.nextLine();

        System.out.print("Enter Patient ID: ");
        String newPatientID = scanner.nextLine();

        System.out.println("Patient Registered!");
        return new Patient(newPatientName, newPatientID);
    }

    private static void addService(Patient patient) {
        if (patient == null) {
            System.out.println("Register a patient first.");
            return;
        }

        Scanner scanner = new Scanner(System.in);

        System.out.println("Available Services: Xray (500), Surgery (12000), Consultation (700)");
        System.out.print("Select service to add: ");

        String serviceSelected = scanner.next();
        ServiceFactory serviceFactory = new ServiceFactory();
        Service service = serviceFactory.getService(serviceSelected);

        if (service == null){
            System.out.println("Service is not available.");
            return;
        }

        patient.addBill(service.addServiceToBill());
        System.out.println("Service added to patient bill.");
    }

    private static void computeBill(Patient patient) {
        if (patient == null) {
            System.out.println("Register a patient first.");
            return;
        }

        if (patient.getBill() == 0) {
            System.out.println("No services added yet.");
            return;
        }

        System.out.print("Enter insurance type (HMO/Cash/Senior): ");
        Scanner scanner = new Scanner(System.in);
        String insuranceType = scanner.next();

        switch (insuranceType.toLowerCase()) {
            case "hmo":
                patient.setBillingStrategy(new HMOBilling());
                break;
            case "senior":
                patient.setBillingStrategy(new SeniorBilling());
                break;
            default:
                patient.setBillingStrategy(new CashBilling());
                break;
        }

        patient.generateBill();
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
                    patient = registerPatient();
                    break;
                case 2:
                    addService(patient);
                    break;
                case 3:
                    computeBill(patient);
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