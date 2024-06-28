package com.flipkart.business;

import com.flipkart.bean.Booking;
import com.flipkart.dao.BookingGymDAOImpl;
import com.flipkart.exceptions.BookingFailedException;
import com.flipkart.exceptions.GymNotFoundException;

import java.sql.*;
import java.util.List;

public class BookingGymService implements BookingGymInterface {

    public static void main(String[] args) {
        // Instantiate the BookingGymService
        BookingGymService bookingService = new BookingGymService();
        try{
            bookingService.createBooking(1, 101, 70, 303, "2024-06-28", "3", "Standard", 1500);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }


        private final BookingGymDAOImpl bookingDAO = new BookingGymDAOImpl();

    Booking booking = new Booking();

    @Override
    public void createBooking(int bookingId, int customerId, int gymId, int transactionId, String bookingDate, String bookingTimeSlot, String bookingType, int bookingAmount){
        try {
            if (bookingDAO.isGymAvailable(gymId)){
                bookingDAO.createBooking(bookingId, customerId, gymId, transactionId, bookingDate, bookingTimeSlot, bookingType, bookingAmount);
                System.out.println("Booking is Done!!");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void bookSlots() {
        try {
            bookingDAO.bookSlots();
            System.out.println("Slot is booked");
        } catch (Exception e) {
            System.out.println("Failed to book slot: " + e.getMessage());
        }
    }

    @Override
    public void viewBookings() throws BookingFailedException {
        try {
            List<Booking> bookings = bookingDAO.viewBookings();
            for (Booking booking : bookings) {
                System.out.println(booking);
            }
        } catch (Exception e) {
            throw new BookingFailedException("Failed to view bookings: " + e.getMessage());
        }
    }

    @Override
    public void cancelBookings() throws BookingFailedException {
        try {
            bookingDAO.cancelBookings();
            System.out.println("Slot is cancelled");
        } catch (Exception e) {
            throw new BookingFailedException("Failed to cancel booking: " + e.getMessage());
        }
    }

    @Override
    public void makePayment() throws BookingFailedException {
        try {
            bookingDAO.makePayment();
            System.out.println("Payment Successful!");
        } catch (Exception e) {
            throw new BookingFailedException("Failed to make payment: " + e.getMessage());
        }
    }



}
