package com.flipkart.business;

import com.flipkart.bean.Booking;

public class BookingService implements BookingInterface {

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

    public void bookSlots(){
        System.out.println("Slot is booked");
    }

    public void viewBookings(){
        System.out.println("All bookings are viewed");
    }

    public void cancelBookings(){
        System.out.println("Slot is cancelled");
    }

    public void makePayment() {
        System.out.println("Payment Successful!");
    }

}
