package com.flipkart.business;

import com.flipkart.bean.Booking;
import com.flipkart.dao.BookingGymDAOImpl;
import com.flipkart.dao.BookingGymDAOInterface;
import com.flipkart.dao.FlipFitCustomerDAOImpl;
import com.flipkart.dao.FlipFitCustomerDAOInterface;
import com.flipkart.exceptions.BookingFailedException;

import java.util.List;


/**
 * Service class implementing BookingGymInterface.
 * Handles business logic for booking gyms, interacting with DAO layer for data operations.
 */
public class BookingGymService implements BookingGymInterface {

    BookingGymDAOInterface bookingGymDAO = new BookingGymDAOImpl();

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
    public void createBooking(int userId, int gymId, int transactionId, String bookingDate, String bookingTimeSlot, String bookingType, int bookingAmount) throws Exception {
        
            bookingGymDAO.createBooking(userId, gymId, transactionId, bookingDate, bookingTimeSlot, bookingType, bookingAmount);
            System.out.println("Booking is Done!!");
       
    }

    /**
     * Simulates booking slots for a gym.
     *
     * @throws BookingFailedException if the booking process fails.
     */

    public void bookSlots() throws BookingFailedException{
        System.out.println("Slot is booked");
    }

    /**
     * Retrieves all bookings made by a user.
     *
     * @param userId The ID of the user.
     * @return A list of bookings made by the user.
     */

    public List<Booking> viewBookings(int userId){
        return bookingGymDAO.viewBookings(userId);
    }

    /**
     * Cancels a booking.
     *
     * @param bookingId The ID of the booking to cancel.
     * @throws Exception if there is an error while canceling the booking.
     */
    public void cancelBookings(int bookingId) throws Exception{
    	  bookingGymDAO.cancelBookings(bookingId);
        System.out.println("Booking is cancelled");
    }

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

    public int makePayment(int userId, String paymentDetails, String expiryDate, String modeOfPayment) throws BookingFailedException{
        try{
            System.out.println("Payment Successful!");
            return bookingGymDAO.makePayment(userId, paymentDetails, expiryDate, modeOfPayment);
        }
        catch(BookingFailedException e){
            throw new BookingFailedException(e.getMessage());
        }
    }
}
