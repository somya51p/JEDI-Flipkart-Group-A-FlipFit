package com.flipkart.bean;

public class Payment {
    private int transactionId;
    private String paymentDetails;
    private String expiryDate;
    private String modeOfPayment;

    /**
     * Constructor to initialize a Payment object.
     *
     * @param transactionId  The unique identifier for the transaction.
     * @param paymentDetails Details about the payment (e.g., card number, account details).
     * @param expiryDate     Expiry date of the payment method (e.g., card expiry date).
     * @param modeOfPayment  The mode of payment used (e.g., credit card, debit card).
     */
    public Payment(int transactionId, String paymentDetails, String expiryDate, String modeOfPayment) {
        this.transactionId = transactionId;
        this.paymentDetails = paymentDetails;
        this.expiryDate = expiryDate;
        this.modeOfPayment = modeOfPayment;
    }

    /**
     * Retrieves the transaction ID.
     *
     * @return The transaction ID.
     */
    public int getTransactionId() {
        return transactionId;
    }

    /**
     * Sets the transaction ID.
     *
     * @param transactionId The transaction ID to set.
     */
    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    /**
     * Retrieves the payment details.
     *
     * @return The payment details.
     */
    public String getPaymentDetails() {
        return paymentDetails;
    }

    /**
     * Sets the payment details.
     *
     * @param paymentDetails The payment details to set.
     */
    public void setPaymentDetails(String paymentDetails) {
        this.paymentDetails = paymentDetails;
    }

    /**
     * Retrieves the expiry date of the payment method.
     *
     * @return The expiry date.
     */
    public String getExpiryDate() {
        return expiryDate;
    }

    /**
     * Sets the expiry date of the payment method.
     *
     * @param expiryDate The expiry date to set.
     */
    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    /**
     * Retrieves the mode of payment.
     *
     * @return The mode of payment.
     */
    public String getModeOfPayment() {
        return modeOfPayment;
    }

    /**
     * Sets the mode of payment.
     *
     * @param modeOfPayment The mode of payment to set.
     */

    public void setModeOfPayment(String modeOfPayment) {
        this.modeOfPayment = modeOfPayment;
    }
}
