package main.java.com.flipkart.bean;

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

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getGymId() {
        return gymId;
    }

    public void setGymId(int gymId) {
        this.gymId = gymId;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getBookingTimeSlot() {
        return bookingTimeSlot;
    }

    public void setBookingTimeSlot(String bookingTimeSlot) {
        this.bookingTimeSlot = bookingTimeSlot;
    }

    public String getBookingType() {
        return bookingType;
    }

    public void setBookingType(String bookingType) {
        this.bookingType = bookingType;
    }

    public int getBookingAmount() {
        return bookingAmount;
    }

    public void setBookingAmount(int bookingAmount) {
        this.bookingAmount = bookingAmount;
    }
}
