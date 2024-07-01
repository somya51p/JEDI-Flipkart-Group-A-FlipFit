package com.flipkart.bean;

/**
 * Represents a payment in the system.
 */
public class Payment {
    private int transactionId;       // Unique identifier for the transaction
    private String paymentDetails;   // Details of the payment (e.g., card number, bank account)
    private String expiryDate;       // Expiry date of the payment method
    private String modeOfPayment;    // Mode of payment (e.g., credit card, debit card, net banking)

    /**
     * Constructs a Payment object with the given details.
     *
     * @param transactionId    The unique identifier for the transaction.
     * @param paymentDetails   The details of the payment.
     * @param expiryDate       The expiry date of the payment method.
     * @param modeOfPayment    The mode of payment.
     */
    public Payment(int transactionId, String paymentDetails, String expiryDate, String modeOfPayment) {
        this.transactionId = transactionId;
        this.paymentDetails = paymentDetails;
        this.expiryDate = expiryDate;
        this.modeOfPayment = modeOfPayment;
    }

    /**
     * Gets the unique identifier for the transaction.
     * @return The transaction ID.
     */
    public int getTransactionId() {
        return transactionId;
    }

    /**
     * Sets the unique identifier for the transaction.
     * @param transactionId The transaction ID to set.
     */
    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    /**
     * Gets the details of the payment.
     * @return The payment details.
     */
    public String getPaymentDetails() {
        return paymentDetails;
    }

    /**
     * Sets the details of the payment.
     * @param paymentDetails The payment details to set.
     */
    public void setPaymentDetails(String paymentDetails) {
        this.paymentDetails = paymentDetails;
    }

    /**
     * Gets the expiry date of the payment method.
     * @return The expiry date.
     */
    public String getExpiryDate() {
        return expiryDate;
    }

    /**
     * Sets the expiry date of the payment method.
     * @param expiryDate The expiry date to set.
     */
    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    /**
     * Gets the mode of payment.
     * @return The mode of payment.
     */
    public String getModeOfPayment() {
        return modeOfPayment;
    }

    /**
     * Sets the mode of payment.
     * @param modeOfPayment The mode of payment to set.
     */
    public void setModeOfPayment(String modeOfPayment) {
        this.modeOfPayment = modeOfPayment;
    }
}
