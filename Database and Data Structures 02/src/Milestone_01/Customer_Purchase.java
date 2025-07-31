package Milestone_01;

public class Customer_Purchase {

    private int itemQuantity;

    // Constructor to initialize item quantity
    public Customer_Purchase(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    // Calculate the shipping fee based on the number of items
    public double ShippingFeeCalculation() {
        return itemQuantity * 150.0;
    }

    // Calculate the tax for the order
    public double TaxCalculation() {
        return 0.1 * ShippingFeeCalculation(); // Assuming a 10% tax rate
    }

    // Calculate the total cost, including shipping fee and tax
    public double TotalCostCalculation() {
        return ShippingFeeCalculation() + TaxCalculation();
    }

    // Get the item quantity for this order
    public int ObtainQuantity() {
        return itemQuantity;
    }
}
