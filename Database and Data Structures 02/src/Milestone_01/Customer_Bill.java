package Milestone_01;

import java.util.ArrayList;
import java.util.List;

public class Customer_Bill {

    private String fullName;
    private String contactNumber;
    private String shippingAddress;
    private List<Customer_Purchase> orders;

    // Constructor to initialize the Invoice/Bill object
    public Customer_Bill(String fullName, String shippingAddress, String contactNumber) {
        this.fullName = fullName;
        this.shippingAddress = shippingAddress;
        this.contactNumber = contactNumber;
        this.orders = new ArrayList<>();
    }

    // Method to add an order to the list of orders
    public void addOrder(Customer_Purchase order) {
        orders.add(order);
    }

    // Method to calculate the total cost of all orders in the bill
    public double TotalCostCalculation() {
        double totalCost = 0.0;
        for (Customer_Purchase order : orders) {
            totalCost += order.TotalCostCalculation();
        }
        return totalCost;
    }

    // Method to print the invoice details
    public void printInvoice() {
        System.out.println("\nInvoice for " + fullName + ":");
        System.out.println("Full Name: " + fullName);
        System.out.println("Shipping Address: " + shippingAddress);
        System.out.println("Contact Number: " + contactNumber);
        System.out.println("Total Number of Items: " + calculateTotalItems());
        System.out.println("Total Cost: $" + TotalCostCalculation());
    }

    // Method to calculate the total number of items in the invoice
    public int calculateTotalItems() {
        int totalNumberofItems = 0;
        for (Customer_Purchase order : orders) {
            totalNumberofItems += order.ObtainQuantity();
        }
        return totalNumberofItems;
    }
}
