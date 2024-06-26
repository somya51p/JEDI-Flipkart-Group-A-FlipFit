package com.flipkart.business;

public interface BookingInterface {

    public void createBooking(int bookingId, int customerId, int gymId, int transactionId, String bookingDate, String bookingTimeSlot, String bookingType, int bookingAmount);
    public void bookSlots();
    public void viewBookings();
    public void cancelBookings();
    public void makePayment();
}
