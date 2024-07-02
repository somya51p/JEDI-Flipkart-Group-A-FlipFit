package com.flipkart.dao;

import com.flipkart.bean.Booking;
import com.flipkart.exceptions.BookingFailedException;

import java.util.List;

/**
 * Interface for defining operations related to gym bookings.
 */
public interface BookingGymDAOInterface {

    /**
     * Creates a new booking.
     *
     * @param userId         ID of the user making the booking.
     * @param gymId          ID of the gym being booked.
     * @param transactionId  Transaction ID associated with the booking.
     * @param bookingDate    Date of the booking.
     * @param bookingTimeSlot Time slot for the booking.
     * @param bookingType    Type of booking (e.g., confirmed, tentative).
     * @param bookingAmount  Amount paid for the booking.
     * @throws BookingFailedException If the booking creation fails.
     */
    public void createBooking(int userId, int gymId, int transactionId, String bookingDate, String bookingTimeSlot, String bookingType, int bookingAmount) throws BookingFailedException;

    /**
     * Method placeholder for booking slots functionality.
     *
     * @throws BookingFailedException If booking slots operation fails.
     */
    public void bookSlots() throws BookingFailedException;

    /**
     * Retrieves all bookings made by a user.
     *
     * @param userId ID of the user whose bookings are to be retrieved.
     * @return List of bookings made by the user.
     */
    public List<Booking> viewBookings(int userId);

    /**
     * Cancels a specific booking and its associated payment.
     *
     * @param bookingId ID of the booking to be canceled.
     */
    public void cancelBookings(int bookingId);

    /**
     * Records a payment for a booking.
     *
     * @param userId         ID of the user making the payment.
     * @param paymentDetails Details of the payment.
     * @param expiryDate     Expiry date of the payment method.
     * @param modeOfPayment  Mode of payment (e.g., net banking, credit card).
     * @return Transaction ID generated for the payment.
     * @throws BookingFailedException If the payment recording fails.
     */
    public int makePayment(int userId, String paymentDetails, String expiryDate, String modeOfPayment) throws BookingFailedException;
}
