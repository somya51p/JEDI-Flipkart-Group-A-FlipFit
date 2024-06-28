package com.flipkart.bean;

public class Booking {
    private int bookingId;
    private int customerId;
    private int gymId;
    private int transactionId;
    private String bookingDate;
    private String bookingTimeSlot;
    private String bookingType;
    private int bookingAmount;

    public Booking(int bookingId, int customerId, int gymId, int transactionId, String bookingDate, String bookingTimeSlot, String bookingType, int bookingAmount) {
        this.bookingId = bookingId;
        this.customerId = customerId;
        this.gymId = gymId;
        this.transactionId = transactionId;
        this.bookingDate = bookingDate;
        this.bookingTimeSlot = bookingTimeSlot;
        this.bookingType = bookingType;
        this.bookingAmount = bookingAmount;
    }
    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getGymId() {
        return gymId;
    }

    public void setGymId(int gymId) {
        this.gymId = gymId;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getBookingTimeSlot() {
        return bookingTimeSlot;
    }

    public void setBookingTimeSlot(String bookingTimeSlot) {
        this.bookingTimeSlot = bookingTimeSlot;
    }

    public String getBookingType() {
        return bookingType;
    }

    public void setBookingType(String bookingType) {
        this.bookingType = bookingType;
    }

    public int getBookingAmount() {
        return bookingAmount;
    }

    public void setBookingAmount(int bookingAmount) {
        this.bookingAmount = bookingAmount;
    }
}
