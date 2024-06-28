package com.flipkart.business;

public interface BookingGymInterface {

    public void createBooking(int userId, int gymId, int transactionId, String bookingDate, String bookingTimeSlot, String bookingType, int bookingAmount);
    public void bookSlots();
    public void viewBookings(int userId);
    public void cancelBookings(int bookingId);
    public int makePayment(int userId, String paymentDetails, String expiryDate, String modeOfPayment);
}
