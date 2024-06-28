package com.flipkart.business;

public interface BookingGymInterface {

    public void createBooking(int bookingId, int customerId, int gymId, int transactionId, String bookingDate, String bookingTimeSlot, String bookingType, int bookingAmount);
    public void bookSlots(int userId);
    public void viewBookings(int userId);
    public void cancelBookings(int bookingId);
    public void makePayment(int userId);
}
