package com.flipkart.business;

import com.flipkart.bean.Booking;
import com.flipkart.dao.BookingGymDAOImpl;
import com.flipkart.dao.BookingGymDAOInterface;
import com.flipkart.exceptions.BookingFailedException;

import java.util.List;

/**
 * Service class for handling gym bookings.
 */
public class BookingGymService implements BookingGymInterface {

    // DAO interface for booking gym
    BookingGymDAOInterface bookingGymDAO = new BookingGymDAOImpl();

    /**
     * Creates a booking with the specified details.
     *
     * @param userId           The ID of the user making the booking.
     * @param gymId            The ID of the gym being booked.
     * @param transactionId    The ID of the transaction associated with the booking.
     * @param bookingDate      The date of the booking.
     * @param bookingTimeSlot  The time slot of the booking.
     * @param bookingType      The type of the booking (e.g., online, in-person).
     * @param bookingAmount    The amount charged for the booking.
     */
    public void createBooking(int userId, int gymId, int transactionId, String bookingDate, String bookingTimeSlot, String bookingType, int bookingAmount) {
        try {
            bookingGymDAO.createBooking(userId, gymId, transactionId, bookingDate, bookingTimeSlot, bookingType, bookingAmount);
            System.out.println("Booking is Done!!");
        } catch (BookingFailedException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Books a slot for a gym.
     *
     * @throws BookingFailedException if the booking fails.
     */
    public void bookSlots() throws BookingFailedException {
        System.out.println("Slot is booked");
    }

    /**
     * Views the bookings for a specified user.
     *
     * @param userId The ID of the user whose bookings are to be viewed.
     * @return A list of bookings for the specified user.
     */
    public List<Booking> viewBookings(int userId) {
        return bookingGymDAO.viewBookings(userId);
    }

    /**
     * Cancels a booking with the specified booking ID.
     *
     * @param bookingId The ID of the booking to be canceled.
     */
    public void cancelBookings(int bookingId) {
        bookingGymDAO.cancelBookings(bookingId);
        System.out.println("Booking is cancelled");
    }

    /**
     * Makes a payment for a booking.
     *
     * @param userId         The ID of the user making the payment.
     * @param paymentDetails The payment details.
     * @param expiryDate     The expiry date of the payment method.
     * @param modeOfPayment  The mode of payment (e.g., credit card, debit card).
     * @return The transaction ID of the payment.
     * @throws BookingFailedException if the payment fails.
     */
    public int makePayment(int userId, String paymentDetails, String expiryDate, String modeOfPayment) throws BookingFailedException {
        try {
            System.out.println("Payment Successful!");
            return bookingGymDAO.makePayment(userId, paymentDetails, expiryDate, modeOfPayment);
        } catch (BookingFailedException e) {
            throw new BookingFailedException(e.getMessage());
        }
    }
}
