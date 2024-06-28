package com.flipkart.business;

import com.flipkart.bean.Booking;

public class BookingGymService implements BookingGymInterface {

    Booking booking = new Booking();

<<<<<<< Updated upstream
    public void createBooking(int bookingId, int customerId, int gymId, int transactionId, String bookingDate, String bookingTimeSlot, String bookingType, int bookingAmount) {
        booking.setBookingId(bookingId);
        booking.setCustomerId(customerId);
        booking.setGymId(gymId);
        booking.setTransactionId(transactionId);
        booking.setBookingDate(bookingDate);
        booking.setBookingTimeSlot(bookingTimeSlot);
        booking.setBookingType(bookingType);
        booking.setBookingAmount(bookingAmount);
=======
    public void createBooking(int userId, int gymId, int transactionId, String bookingDate, String bookingTimeSlot, String bookingType, int bookingAmount) {
        bookingGymDAO.createBooking(userId, gymId, transactionId, bookingDate, bookingTimeSlot, bookingType, bookingAmount);
>>>>>>> Stashed changes
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

<<<<<<< Updated upstream
    public void makePayment() {
=======
    public int makePayment(int userId, String paymentDetails, String expiryDate, String modeOfPayment) {
>>>>>>> Stashed changes
        System.out.println("Payment Successful!");
        return bookingGymDAO.makePayment(userId, paymentDetails, expiryDate, modeOfPayment);
    }

}
