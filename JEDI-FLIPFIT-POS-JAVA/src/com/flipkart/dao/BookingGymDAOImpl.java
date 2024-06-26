package com.flipkart.dao;

public class BookingGymDAOImpl implements BookingGymDAOInterface {
    @Override
    public void createBooking(int bookingId, int customerId, int gymId, int transactionId, String bookingDate, String bookingTimeSlot, String bookingType, int bookingAmount) {

    }

    @Override
    public void bookSlots() {

    }

    @Override
    public void viewBookings() {

    }

    @Override
    public void cancelBookings() {

    }

    @Override
    public void makePayment() {

    }
    //data interaction not data manipulation --> client -> service -> DAO
}
