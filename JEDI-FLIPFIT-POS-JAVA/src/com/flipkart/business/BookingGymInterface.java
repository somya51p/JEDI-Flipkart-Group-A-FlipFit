package com.flipkart.business;

import com.flipkart.exceptions.BookingFailedException;

public interface BookingGymInterface {

    public void createBooking(int userId, int gymId, int transactionId, String bookingDate, String bookingTimeSlot, String bookingType, int bookingAmount) throws BookingFailedException;
    public void bookSlots() throws BookingFailedException;
    public void viewBookings(int userId) throws BookingFailedException;
    public void cancelBookings(int bookingId) throws BookingFailedException;
    public int makePayment(int userId, String paymentDetails, String expiryDate, String modeOfPayment) throws BookingFailedException;
}
