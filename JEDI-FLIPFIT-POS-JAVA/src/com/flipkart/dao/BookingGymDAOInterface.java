package com.flipkart.dao;

import com.flipkart.bean.Booking;

import java.util.List;

public interface BookingGymDAOInterface {

    public void createBooking(int bookingId, int customerId, int gymId, int transactionId, String bookingDate, String bookingTimeSlot, String bookingType, int bookingAmount);
    public void bookSlots();
    public List<Booking> viewBookings(int userId);
    public void cancelBookings(int bookingId);
    public void makePayment(int transactionId, int cardNumber, String expiryDate, String modeOfPayment);
}
