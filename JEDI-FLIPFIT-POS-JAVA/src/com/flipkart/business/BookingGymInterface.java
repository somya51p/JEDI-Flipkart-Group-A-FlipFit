package com.flipkart.business;

public interface BookingGymInterface {

<<<<<<< Updated upstream
    public void createBooking(int bookingId, int customerId, int gymId, int transactionId, String bookingDate, String bookingTimeSlot, String bookingType, int bookingAmount);
    public void bookSlots();
    public void viewBookings();
    public void cancelBookings();
    public void makePayment();
=======
    public void createBooking(int userId, int gymId, int transactionId, String bookingDate, String bookingTimeSlot, String bookingType, int bookingAmount);
    public void bookSlots(int userId);
    public void viewBookings(int userId);
    public void cancelBookings();
    public int makePayment(int userId, String paymentDetails, String expiryDate, String modeOfPayment);
>>>>>>> Stashed changes
}
