package com.flipkart.business;

import com.flipkart.bean.Booking;
import com.flipkart.dao.BookingGymDAOImpl;
import com.flipkart.dao.BookingGymDAOInterface;
import com.flipkart.dao.FlipFitCustomerDAOImpl;
import com.flipkart.dao.FlipFitCustomerDAOInterface;

import java.util.List;



public class BookingGymService implements BookingGymInterface {

//        public static void main(String[] args) {
//        BookingGymInterface bookingGymService = new BookingGymService();
//        bookingGymService.viewBookings(1);
//    }

    BookingGymDAOInterface bookingGymDAO = new BookingGymDAOImpl();

    public void createBooking(int userId, int gymId, int transactionId, String bookingDate, String bookingTimeSlot, String bookingType, int bookingAmount) {
        bookingGymDAO.createBooking(userId, gymId, transactionId, bookingDate, bookingTimeSlot, bookingType, bookingAmount);
        System.out.println("Booking is Done!!");
    }

    public void bookSlots(){
        System.out.println("Slot is booked");
    }

    public void viewBookings(int userId) {
        List<Booking> bookings = bookingGymDAO.viewBookings(userId);

        if (bookings.isEmpty()) {
            System.out.println("No bookings found for userId: " + userId);
        } else {
            System.out.println("Bookings for userId: " + userId);
            for (Booking booking : bookings) {
                System.out.println("Booking ID: " + booking.getBookingId());
                System.out.println("Customer ID: " + booking.getCustomerId());
                System.out.println("Gym ID: " + booking.getGymId());
                System.out.println("Transaction ID: " + booking.getTransactionId());
                System.out.println("Booking Date: " + booking.getBookingDate());
                System.out.println("Booking TimeSlot: " + booking.getBookingTimeSlot());
                System.out.println("Booking Type: " + booking.getBookingType());
                System.out.println("Booking Amount: " + booking.getBookingAmount());
                System.out.println("=================================");
            }
        }
    }

    public void cancelBookings(int bookingId){
    	  bookingGymDAO.cancelBookings(bookingId);
        System.out.println("Booking is cancelled");
    }

    public int makePayment(int userId, String paymentDetails, String expiryDate, String modeOfPayment) {
        System.out.println("Payment Successful!");
        return bookingGymDAO.makePayment(userId, paymentDetails, expiryDate, modeOfPayment);
    }

}
