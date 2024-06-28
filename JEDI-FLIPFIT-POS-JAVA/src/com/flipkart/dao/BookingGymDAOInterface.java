package com.flipkart.dao;

public interface BookingGymDAOInterface {

    public void createBooking(int bookingId, int customerId, int gymId, int transactionId, String bookingDate, String bookingTimeSlot, String bookingType, int bookingAmount);
    public void bookSlots();
    public void viewBookings();
    public void cancelBookings(int bookingId);
    public void makePayment(int transactionId, int cardNumber, String expiryDate, String modeOfPayment);
}
