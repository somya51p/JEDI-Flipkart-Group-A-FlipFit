package com.flipkart.business;

import com.flipkart.bean.Booking;
import com.flipkart.dao.BookingGymDAOImpl;
import com.flipkart.dao.BookingGymDAOInterface;

public class BookingGymService implements BookingGymInterface {

    BookingGymDAOInterface bookingGymDAO = new BookingGymDAOImpl();

    public void createBooking(int userId, int gymId, int transactionId, String bookingDate, String bookingTimeSlot, String bookingType, int bookingAmount) {
        bookingGymDAO.createBooking(userId, gymId, transactionId, bookingDate, bookingTimeSlot, bookingType, bookingAmount);
        System.out.println("Booking is Done!!");
    }

    public void bookSlots(){
        System.out.println("Slot is booked");
    }

    public void viewBookings(int userId){
        System.out.println("All bookings are viewed");
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
