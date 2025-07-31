package Milestone_01;

public class Customer {

    private String firstName;
    private String lastName;
    private String contactNumber;
    private String shippingAddress;

    public Customer(String firstName, String lastName, String contactNumber, String shippingAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactNumber = contactNumber;
        this.shippingAddress = shippingAddress;
    }

    public String retrieveFullName() {
        return firstName + " " + lastName;
    }

    public String retrieveContactNumber() {
        return contactNumber;
    }

    public String retrieveShippingAddress() {
        return shippingAddress;
    }
}
