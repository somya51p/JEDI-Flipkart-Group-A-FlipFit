package com.flipkart.dao;

public interface BookingGymDAOInterface {

    public void createBooking(int userId, int gymId, int transactionId, String bookingDate, String bookingTimeSlot, String bookingType, int bookingAmount);
    public void bookSlots();
    public void viewBookings();
<<<<<<< Updated upstream
    public void cancelBookings();
    public void makePayment();
=======
    public void cancelBookings(int bookingId);
    public int makePayment(int userId, String paymentDetails, String expiryDate, String modeOfPayment);
>>>>>>> Stashed changes
}
