package com.flipkart.business;

import com.flipkart.bean.Booking;

public class BookingService {

    Booking booking = new Booking();

    public void createBooking(int bookingId, int customerId, int gymId, int transactionId, String bookingDate, String bookingTimeSlot, String bookingType, int bookingAmount) {
        booking.setBookingId(bookingId);
        booking.setCustomerId(customerId);
        booking.setGymId(gymId);
        booking.setTransactionId(transactionId);
        booking.setBookingDate(bookingDate);
        booking.setBookingTimeSlot(bookingTimeSlot);
        booking.setBookingType(bookingType);
        booking.setBookingAmount(bookingAmount);
        System.out.println("Booking is Done!!");
    }

}
