package com.flipkart.bean;

/**
 * Represents a customer in the FlipFit system.
 */
public class FlipFitCustomer {

    private int customerId;         // Unique identifier for the customer
    private String customerName;    // Name of the customer
    private String customerPhone;   // Phone number of the customer
    private String customerAddress; // Address of the customer
    private int userId;             // Identifier of the associated user

    /**
     * Constructs a FlipFitCustomer object with the given details.
     *
     * @param customerId     The unique identifier for the customer.
     * @param customerName   The name of the customer.
     * @param customerPhone  The phone number of the customer.
     * @param customerAddress The address of the customer.
     * @param userId         The identifier of the associated user.
     */
    public FlipFitCustomer(int customerId, String customerName, String customerPhone, String customerAddress, int userId) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.customerAddress = customerAddress;
        this.userId = userId;
    }

    /**
     * Retrieves the customerId of the customer.
     *
     * @return The customerId of the customer.
     */
    public int getCustomerId() {
        return customerId;
    }

    /**
     * Sets the customerId for the customer.
     *
     * @param customerId The customerId to set.
     */
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    /**
     * Retrieves the customerName of the customer.
     *
     * @return The customerName of the customer.
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * Sets the customerName for the customer.
     *
     * @param customerName The customerName to set.
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * Retrieves the customerPhone of the customer.
     *
     * @return The customerPhone of the customer.
     */
    public String getCustomerPhone() {
        return customerPhone;
    }

    /**
     * Sets the customerPhone for the customer.
     *
     * @param customerPhone The customerPhone to set.
     */
    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    /**
     * Retrieves the customerAddress of the customer.
     *
     * @return The customerAddress of the customer.
     */
    public String getCustomerAddress() {
        return customerAddress;
    }

    /**
     * Sets the customerAddress for the customer.
     *
     * @param customerAddress The customerAddress to set.
     */
    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    /**
     * Retrieves the userId associated with the customer.
     *
     * @return The userId associated with the customer.
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Sets the userId associated with the customer.
     *
     * @param userId The userId to set.
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }
}
