package com.flipkart.dao;

import com.flipkart.bean.Booking;
import com.flipkart.exceptions.BookingFailedException;

import java.util.List;

/**
 * Interface for BookingGymDAOImpl, defining methods for booking-related operations.
 */
public interface BookingGymDAOInterface {

    /**
     * Creates a booking in the database.
     *
     * @param userId          The ID of the user making the booking.
     * @param gymId           The ID of the gym for which the booking is made.
     * @param transactionId   The ID of the transaction associated with the booking.
     * @param bookingDate     The date of the booking.
     * @param bookingTimeSlot The time slot of the booking.
     * @param bookingType     The type of booking.
     * @param bookingAmount   The amount paid for the booking.
     * @throws Exception If an error occurs during the booking creation process.
     */
    public void createBooking(int userId, int gymId, int transactionId, String bookingDate, String bookingTimeSlot, String bookingType, int bookingAmount) throws Exception;

    /**
     * Placeholder method for booking slots (not implemented).
     *
     * @throws BookingFailedException If booking slots operation fails.
     */
    public void bookSlots() throws BookingFailedException;

    /**
     * Retrieves bookings made by a specific user.
     *
     * @param userId The ID of the user.
     * @return A list of bookings made by the user.
     */
    public List<Booking> viewBookings(int userId);

    /**
     * Cancels a booking based on the booking ID.
     *
     * @param bookingId The ID of the booking to cancel.
     * @throws Exception If an error occurs during the cancellation process.
     */
    public void cancelBookings(int bookingId) throws Exception;

    /**
     * Records a payment for a user.
     *
     * @param userId        The ID of the user making the payment.
     * @param paymentDetails The details of the payment.
     * @param expiryDate    The expiry date of the payment method.
     * @param modeOfPayment The mode of payment used (e.g., net banking).
     * @return The transaction ID of the payment if successful.
     * @throws BookingFailedException If the payment recording fails.
     */
    public int makePayment(int userId, String paymentDetails, String expiryDate, String modeOfPayment) throws BookingFailedException;
}
