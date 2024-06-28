package com.flipkart.bean;

public class Payment {
    private int transactionId;
    private int cardNumber;
    private String expiryDate;
    private String modeOfPayment;

    public Payment(int transactionId, int cardNumber, String expiryDate, String modeOfPayment) {
        this.transactionId = transactionId;
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.modeOfPayment = modeOfPayment;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getModeOfPayment() {
        return modeOfPayment;
    }

    public void setModeOfPayment(String modeOfPayment) {
        this.modeOfPayment = modeOfPayment;
    }
}
