package main.java.com.flipkart.business;

import com.flipkart.bean.Booking;
import com.flipkart.exceptions.BookingFailedException;

import java.util.List;

public interface BookingGymInterface {

    public void createBooking(int userId, int gymId, int transactionId, String bookingDate, String bookingTimeSlot, String bookingType, int bookingAmount);
    public void bookSlots() throws BookingFailedException;
    public List<Booking> viewBookings(int userId) throws BookingFailedException;
    public void cancelBookings(int bookingId) throws BookingFailedException;
    public int makePayment(int userId, String paymentDetails, String expiryDate, String modeOfPayment) throws BookingFailedException;
}
