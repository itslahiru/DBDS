package Milestone_01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {
        Customer_Queue queue = new Customer_Queue();
        Scanner scanner = new Scanner(System.in);
        List<Customer_Bill> invoices = new ArrayList<>(); // Store invoices here

        while (true) { // Outer loop for customer/employee selection
            System.out.println("Choose your role:");
            System.out.println("1. Staff");
            System.out.println("2. Customer");
            System.out.println("3. Exit");
            System.out.print("Enter your selection (1, 2, or 3): ");

            int roleChoice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            if (roleChoice == 1) {
                employeeOperations(scanner, queue, invoices);
            } else if (roleChoice == 2) {
                customerOperations(scanner, invoices);
            } else if (roleChoice == 3) {
                System.out.println("Exiting the program.");
                scanner.close();
                System.exit(0);
            } else {
                System.out.println("Invalid selection. Please choose 1 to select \"Staff,\" 2 to select \"Customer,\" or 3 to exit.");
            }
        }
    }

    private static void employeeOperations(Scanner scanner, Customer_Queue queue, List<Customer_Bill> invoices) {
        while (true) { // Employee operations loop
            System.out.println("Staff Operations:");
            System.out.println("1. Add placed orders");
            System.out.println("2. Remove delivered orders");
            System.out.println("3. View placed orders");
            System.out.println("4. View the first order");
            System.out.println("5. View the last order");
            System.out.println("6. Find order");
            System.out.println("7. Analyze Saved Orders");
            System.out.println("8. Return to Role Selection");
            System.out.print("Enter your selection (1 to 8): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter an order value to add: ");
                    int value = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    queue.enqueue(value);
                    break;
                case 2:
                    queue.dequeue();
                    break;
                case 3:
                    queue.printElement();
                    break;
                case 4:
                    queue.front();
                    break;
                case 5:
                    queue.getRear();
                    break;
                case 6:
                    System.out.print("Enter an order value to find: ");
                    int searchValue = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    int position = queue.search(searchValue);
                    if (position != -1) {
                        System.out.println("Value " + searchValue + " found at the position " + position + " in the queue.");
                    } else {
                        System.out.println("Value wasn't available in the queue.");
                    }
                    break;
                case 7:
                    // Display saved invoices
                    if (invoices.isEmpty()) {
                        System.out.println("No invoices were saved.");
                    } else {
                        System.out.println("Saved Invoices:");
                        for (Customer_Bill invoice : invoices) {
                            invoice.printInvoice();
                        }
                    }
                    break;
                case 8:
                    System.out.println("Return to Role Selection.");
                    return; // Return to the main menu
                default:
                    System.out.println("Invalid selection. Please select a legitimate choice.");
                    break;
            }
        }
    }

    private static void customerOperations(Scanner scanner, List<Customer_Bill> invoices) {
        while (true) { // Customer-specific operations loop
            System.out.print("Enter your first name: ");
            String firstName = scanner.nextLine();

            System.out.print("Enter your last name: ");
            String lastName = scanner.nextLine();

            System.out.print("Enter shipping address: ");
            String shippingAddress = scanner.nextLine();

            System.out.print("Enter your contact number: ");
            String contactNumber = scanner.nextLine();

            Customer customer = new Customer(firstName, lastName, shippingAddress, contactNumber);
            Customer_Bill invoice = new Customer_Bill(customer.retrieveFullName(), customer.retrieveContactNumber(), customer.retrieveShippingAddress());

            while (true) { // Customer order loop
                System.out.print("Enter the quantity of items to be ordered ('no' to exit): ");
                String input = scanner.nextLine();

                if (input.equalsIgnoreCase("no")) {
                    System.out.println("Exiting Customer Role.");
                    break; // Exit the customer order loop
                } else {
                    try {
                        int itemQuantity = Integer.parseInt(input);
                        Customer_Purchase order = new Customer_Purchase(itemQuantity);
                        invoice.addOrder(order);

                        System.out.println("Order details:");
                        System.out.println("Number of Items: " + order.ObtainQuantity());
                        System.out.println("Shipping Fee: $" + order.ShippingFeeCalculation());
                        System.out.println("Tax: $" + order.TaxCalculation());
                        System.out.println("Total Cost: $" + order.TotalCostCalculation());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter a legitimate number or 'no' to end.");
                    }
                }
            }

            // Ask if the customer wants to place another order
            System.out.print("Are you interested in placing another order? (yes/no): ");
            String anotherOrder = scanner.nextLine();

            if (anotherOrder.equalsIgnoreCase("no")) {
                invoices.add(invoice); // Save the invoice
                System.out.println("Exiting Customer Role.");
                break; // Exit the customer-specific operations loop
            }
        }
    }
}
