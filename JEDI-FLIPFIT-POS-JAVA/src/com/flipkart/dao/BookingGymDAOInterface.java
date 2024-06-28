package com.flipkart.dao;
import com.flipkart.exceptions.BookingFailedException;
import com.flipkart.bean.Booking;
import java.util.List;

public interface BookingGymDAOInterface {

    public void createBooking(int bookingId, int customerId, int gymId, int transactionId, String bookingDate, String bookingTimeSlot, String bookingType, int bookingAmount);

    boolean isGymAvailable(int gymId) throws Exception;

    public void bookSlots();
    public List<Booking> viewBookings();
    public void cancelBookings();
    public void makePayment();
}
