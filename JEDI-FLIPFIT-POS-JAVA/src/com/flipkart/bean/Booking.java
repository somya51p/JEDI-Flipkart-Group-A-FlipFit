package com.flipkart.bean;

/**
 * Represents a booking in the system.
 */
public class Booking {
    private int bookingId;           // Unique identifier for the booking
    private int customerId;          // Identifier for the customer making the booking
    private int gymId;               // Identifier for the gym where the booking is made
    private int transactionId;       // Identifier for the transaction associated with the booking
    private String bookingDate;      // Date of the booking
    private String bookingTimeSlot;  // Time slot of the booking
    private String bookingType;      // Type of the booking (e.g., online, in-person)
    private int bookingAmount;       // Amount charged for the booking

    /**
     * Constructs a Booking object with the given details.
     *
     * @param bookingId       The unique identifier for the booking.
     * @param customerId      The identifier of the customer making the booking.
     * @param gymId           The identifier of the gym where the booking is made.
     * @param transactionId   The identifier of the transaction associated with the booking.
     * @param bookingDate     The date of the booking.
     * @param bookingTimeSlot The time slot of the booking.
     * @param bookingType     The type of the booking.
     * @param bookingAmount   The amount charged for the booking.
     */
    public Booking(int bookingId, int customerId, int gymId, int transactionId, String bookingDate, String bookingTimeSlot, String bookingType, int bookingAmount) {
        this.bookingId = bookingId;
        this.customerId = customerId;
        this.gymId = gymId;
        this.transactionId = transactionId;
        this.bookingDate = bookingDate;
        this.bookingTimeSlot = bookingTimeSlot;
        this.bookingType = bookingType;
        this.bookingAmount = bookingAmount;
    }

    // Getters and setters for each field

    /**
     * Gets the unique identifier for the booking.
     * @return The booking ID.
     */
    public int getBookingId() {
        return bookingId;
    }

    /**
     * Sets the unique identifier for the booking.
     * @param bookingId The booking ID to set.
     */
    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    /**
     * Gets the identifier for the customer making the booking.
     * @return The customer ID.
     */
    public int getCustomerId() {
        return customerId;
    }

    /**
     * Sets the identifier for the customer making the booking.
     * @param customerId The customer ID to set.
     */
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    /**
     * Gets the identifier for the gym where the booking is made.
     * @return The gym ID.
     */
    public int getGymId() {
        return gymId;
    }

    /**
     * Sets the identifier for the gym where the booking is made.
     * @param gymId The gym ID to set.
     */
    public void setGymId(int gymId) {
        this.gymId = gymId;
    }

    /**
     * Gets the identifier for the transaction associated with the booking.
     * @return The transaction ID.
     */
    public int getTransactionId() {
        return transactionId;
    }

    /**
     * Sets the identifier for the transaction associated with the booking.
     * @param transactionId The transaction ID to set.
     */
    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    /**
     * Gets the date of the booking.
     * @return The booking date.
     */
    public String getBookingDate() {
        return bookingDate;
    }

    /**
     * Sets the date of the booking.
     * @param bookingDate The booking date to set.
     */
    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    /**
     * Gets the time slot of the booking.
     * @return The booking time slot.
     */
    public String getBookingTimeSlot() {
        return bookingTimeSlot;
    }

    /**
     * Sets the time slot of the booking.
     * @param bookingTimeSlot The booking time slot to set.
     */
    public void setBookingTimeSlot(String bookingTimeSlot) {
        this.bookingTimeSlot = bookingTimeSlot;
    }

    /**
     * Gets the type of the booking (e.g., online, in-person).
     * @return The booking type.
     */
    public String getBookingType() {
        return bookingType;
    }

    /**
     * Sets the type of the booking.
     * @param bookingType The booking type to set.
     */
    public void setBookingType(String bookingType) {
        this.bookingType = bookingType;
    }

    /**
     * Gets the amount charged for the booking.
     * @return The booking amount.
     */
    public int getBookingAmount() {
        return bookingAmount;
    }

    /**
     * Sets the amount charged for the booking.
     * @param bookingAmount The booking amount to set.
     */
    public void setBookingAmount(int bookingAmount) {
        this.bookingAmount = bookingAmount;
    }
}
