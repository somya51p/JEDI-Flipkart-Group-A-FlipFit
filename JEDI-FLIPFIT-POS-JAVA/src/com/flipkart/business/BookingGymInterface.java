package com.flipkart.business;

import com.flipkart.bean.Booking;
import com.flipkart.exceptions.BookingFailedException;
import com.flipkart.exceptions.GymNotFoundException;

public interface BookingGymInterface {

    public void createBooking(int bookingId, int customerId, int gymId, int transactionId, String bookingDate, String bookingTimeSlot, String bookingType, int bookingAmount) throws BookingFailedException, GymNotFoundException;
    public void bookSlots() throws BookingFailedException;
    public void viewBookings() throws BookingFailedException;
    public void cancelBookings() throws BookingFailedException;
    public void makePayment() throws BookingFailedException;
}
