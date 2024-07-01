package com.flipkart.business;

import com.flipkart.bean.Booking;
import com.flipkart.dao.BookingGymDAOImpl;
import com.flipkart.dao.BookingGymDAOInterface;
import com.flipkart.dao.FlipFitCustomerDAOImpl;
import com.flipkart.dao.FlipFitCustomerDAOInterface;
import com.flipkart.exceptions.BookingFailedException;

import java.util.List;



public class BookingGymService implements BookingGymInterface {

    BookingGymDAOInterface bookingGymDAO = new BookingGymDAOImpl();

    public void createBooking(int userId, int gymId, int transactionId, String bookingDate, String bookingTimeSlot, String bookingType, int bookingAmount) throws Exception {
        
            bookingGymDAO.createBooking(userId, gymId, transactionId, bookingDate, bookingTimeSlot, bookingType, bookingAmount);
            System.out.println("Booking is Done!!");
       
    }

    public void bookSlots() throws BookingFailedException{
        System.out.println("Slot is booked");
    }

    public List<Booking> viewBookings(int userId){
        return bookingGymDAO.viewBookings(userId);
    }

    public void cancelBookings(int bookingId) throws Exception{
    	  bookingGymDAO.cancelBookings(bookingId);
        System.out.println("Booking is cancelled");
    }

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
