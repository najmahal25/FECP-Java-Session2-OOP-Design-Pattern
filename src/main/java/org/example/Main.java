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

    private static void registerPatient() {
        // Call register patient
        System.out.println("Register Patient");
    }

    private static void addService() {
        // Call add service
        System.out.println("Add Service");
    }

    private static void computeBill() {
        // Call compute billing
        System.out.println("Compute Billing");
    }

    public static void main(String[] args) {
        // Initialize variables
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        displayMenu();

        while (choice != 4) {
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    registerPatient();
                    break;
                case 2:
                    addService();
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