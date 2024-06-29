package main.java.com.flipkart.dao;

import com.flipkart.bean.Booking;
import com.flipkart.exceptions.BookingFailedException;

import java.util.List;

public interface BookingGymDAOInterface {

    public void createBooking(int userId, int gymId, int transactionId, String bookingDate, String bookingTimeSlot, String bookingType, int bookingAmount) throws BookingFailedException;
    public void bookSlots() throws BookingFailedException;
    public List<Booking> viewBookings(int userId);
    public void cancelBookings(int bookingId);
    public int makePayment(int userId, String paymentDetails, String expiryDate, String modeOfPayment) throws BookingFailedException;
}
