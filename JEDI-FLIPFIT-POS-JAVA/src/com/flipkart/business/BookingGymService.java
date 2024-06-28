package com.flipkart.business;

import com.flipkart.bean.Booking;
import com.flipkart.dao.BookingGymDAOImpl;
import com.flipkart.dao.BookingGymDAOInterface;

public class BookingGymService implements BookingGymInterface {

    BookingGymDAOInterface bookingGymDAO = new BookingGymDAOImpl();

    public void createBooking(int bookingId, int customerId, int gymId, int transactionId, String bookingDate, String bookingTimeSlot, String bookingType, int bookingAmount) {
//        bookingGymDAO.createBooking();
        System.out.println("Booking is Done!!");
    }

    public void bookSlots(int userId){
        System.out.println("Slot is booked");
    }

    public void viewBookings(int userId){
        System.out.println("All bookings are viewed");
    }

    public void cancelBookings(){
        System.out.println("Slot is cancelled");
    }

    public void makePayment(int userId) {
        System.out.println("Payment Successful!");
    }

}
