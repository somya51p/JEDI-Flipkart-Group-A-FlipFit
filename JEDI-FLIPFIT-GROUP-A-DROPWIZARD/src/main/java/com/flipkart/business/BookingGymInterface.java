package com.flipkart.business;

import com.flipkart.bean.Booking;
import com.flipkart.exceptions.BookingFailedException;

import java.util.List;

/**
 * Interface defining operations related to booking gyms in the system.
 */
public interface BookingGymInterface {

    /**
     * Creates a new booking for a gym.
     *
     * @param userId         The ID of the user making the booking.
     * @param gymId          The ID of the gym being booked.
     * @param transactionId  The transaction ID associated with the booking.
     * @param bookingDate    The date of the booking.
     * @param bookingTimeSlot The time slot of the booking.
     * @param bookingType    The type of booking (e.g., regular, premium).
     * @param bookingAmount  The amount to be paid for the booking.
     * @throws Exception if there is an error while creating the booking.
     */
    public void createBooking(int userId, int gymId, int transactionId, String bookingDate, String bookingTimeSlot, String bookingType, int bookingAmount) throws Exception;

    /**
     * Books available slots for a gym.
     *
     * @throws BookingFailedException if the booking process fails.
     */
    public void bookSlots() throws BookingFailedException;

    /**
     * Retrieves all bookings made by a user.
     *
     * @param userId The ID of the user.
     * @return A list of bookings made by the user.
     * @throws BookingFailedException if there is an error while retrieving bookings.
     */
    public List<Booking> viewBookings(int userId) throws BookingFailedException;

    /**
     * Cancels a booking.
     *
     * @param bookingId The ID of the booking to cancel.
     * @throws Exception if there is an error while canceling the booking.
     */
    public void cancelBookings(int bookingId) throws Exception;

    /**
     * Initiates a payment for a booking.
     *
     * @param userId         The ID of the user making the payment.
     * @param paymentDetails The payment details.
     * @param expiryDate     The expiry date of the payment method.
     * @param modeOfPayment  The mode of payment (e.g., credit card, PayPal).
     * @return The transaction ID associated with the payment.
     * @throws BookingFailedException if there is an error while making the payment.
     */
    public int makePayment(int userId, String paymentDetails, String expiryDate, String modeOfPayment) throws BookingFailedException;
}
