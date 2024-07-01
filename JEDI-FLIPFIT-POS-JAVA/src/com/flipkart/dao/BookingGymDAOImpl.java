package com.flipkart.dao;

import com.flipkart.bean.Booking;
import com.flipkart.business.BookingGymInterface;
import com.flipkart.exceptions.BookingFailedException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of BookingGymDAOInterface for handling gym booking operations in the database.
 */
public class BookingGymDAOImpl implements BookingGymDAOInterface {

    public static void main(String[] args) {
        BookingGymDAOInterface dao = new BookingGymDAOImpl();
//        dao.createBooking(1, 1, 150, 250, "02-03-24","5", "confirmed", 500);
//        dao.makePayment(2, 1111333333, "12/25", "net banking");
        dao.cancelBookings(2);
    }
    /**
     * Creates a new booking in the database.
     *
     * @param userId         ID of the user making the booking.
     * @param gymId          ID of the gym being booked.
     * @param transactionId  Transaction ID associated with the booking.
     * @param bookingDate    Date of the booking.
     * @param bookingTimeSlot Time slot for the booking.
     * @param bookingType    Type of booking (e.g., confirmed, tentative).
     * @param bookingAmount  Amount paid for the booking.
     * @throws BookingFailedException If the booking creation fails.
     */

    @Override
    public void createBooking(int userId, int gymId, int transactionId, String bookingDate, String bookingTimeSlot, String bookingType, int bookingAmount) throws BookingFailedException {
        Connection con = null;
        PreparedStatement stmt = null;
        PreparedStatement stmtcustomer = null;
        ResultSet rs1 = null;
        int customerId = 0;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(

                    "jdbc:mysql://localhost:3306/FlipFit", "root", "mysqliswow");

            String queryOwner = "SELECT customerId FROM flipfitCustomer WHERE userId = ?";
            stmtcustomer = con.prepareStatement(queryOwner);
            stmtcustomer.setInt(1, userId);

            rs1 = stmtcustomer.executeQuery();

            while (rs1.next()) {
                customerId = rs1.getInt("customerId");
            }

            String query = "INSERT INTO booking (customerId, gymId, transactionId, bookingDate, bookingTimeSlot, bookingType, bookingAmount) VALUES (?, ?, ?, ?, ?, ?, ?)";
            stmt = con.prepareStatement(query);

            stmt.setInt(1, customerId);
            stmt.setInt(2, gymId);
            stmt.setInt(3, transactionId);
            stmt.setString(4, bookingDate);
            stmt.setString(5, bookingTimeSlot);
            stmt.setString(6, bookingType);
            stmt.setInt(7, bookingAmount);

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Booking created successfully");
            } else {
                throw new BookingFailedException("Failed to create booking");
            }
        } catch (Exception e) {
            throw new BookingFailedException(e.getMessage());
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (Exception e) {
                System.out.println("Error closing resources: " + e.getMessage());
            }
        }
    }


    /**
     * Method placeholder for booking slots functionality (not implemented in this version).
     */
    @Override
    public void bookSlots() {
        // Method placeholder
    }
    /**
     * Retrieves all bookings made by a user.
     *
     * @param userId ID of the user whose bookings are to be retrieved.
     * @return List of bookings made by the user.
     */
    @Override
    public List<Booking> viewBookings(int userId){
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Booking> bookings = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/FlipFit", "root", "mysqliswow");

            // First, get the customerId from the userId
            String customerQuery = "SELECT customerId FROM flipfitCustomer WHERE userId = ?";
            stmt = con.prepareStatement(customerQuery);
            stmt.setInt(1, userId);
            rs = stmt.executeQuery();

            int customerId = -1;
            if (rs.next()) {
                customerId = rs.getInt("customerId");
            } else {
                System.out.println("No customer found with userId: " + userId);
                return bookings; // return empty list if no customer found
            }

            rs.close();
            stmt.close();

            // Now, get all bookings for the customerId
            String bookingQuery = "SELECT * FROM booking WHERE customerId = ?";
            stmt = con.prepareStatement(bookingQuery);
            stmt.setInt(1, customerId);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int bookingId = rs.getInt("bookingId");
                int gymId = rs.getInt("gymId");
                int transactionId = rs.getInt("transactionId");
                String bookingDate = rs.getString("bookingDate");
                String bookingTimeSlot = rs.getString("bookingTimeSlot");
                String bookingType = rs.getString("bookingType");
                int bookingAmount = rs.getInt("bookingAmount");

                Booking booking = new Booking(bookingId, customerId, gymId, transactionId, bookingDate, bookingTimeSlot, bookingType, bookingAmount);

                bookings.add(booking);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (Exception e) {
                System.out.println("Error closing resources: " + e.getMessage());
            }
        }

        return bookings;
    }

    /**
     * Cancels a booking and associated payment from the database.
     *
     * @param bookingId ID of the booking to be canceled.
     */
    @Override
    public void cancelBookings(int bookingId) {
        Connection con = null;
        PreparedStatement stmtSelect = null;
        PreparedStatement stmtDeleteBooking = null;
        PreparedStatement stmtDeletePayment = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/FlipFit", "root", "mysqliswow");

            String querySelect = "SELECT transactionId FROM Booking WHERE bookingId = ?";
            stmtSelect = con.prepareStatement(querySelect);
            stmtSelect.setInt(1, bookingId);
            rs = stmtSelect.executeQuery();

            if (rs.next()) {
                int transactionId = rs.getInt("transactionId");
                String queryDeleteBooking = "DELETE FROM Booking WHERE bookingId = ?";
                stmtDeleteBooking = con.prepareStatement(queryDeleteBooking);
                stmtDeleteBooking.setInt(1, bookingId);
                int resultBooking = stmtDeleteBooking.executeUpdate();

                if (resultBooking > 0) {
                    System.out.println("Booking successfully canceled.");

                    String queryDeletePayment = "DELETE FROM Payment WHERE transactionId = ?";
                    stmtDeletePayment = con.prepareStatement(queryDeletePayment);
                    stmtDeletePayment.setInt(1, transactionId);
                    int resultPayment = stmtDeletePayment.executeUpdate();

                    if (resultPayment > 0) {
                        System.out.println("Payment successfully removed.");
                    } else {
                        System.out.println("No payment found with the given transactionId.");
                    }
                } else {
                    System.out.println("No booking found with the given bookingId.");
                }
            } else {
                System.out.println("No booking found with the given bookingId.");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmtSelect != null) stmtSelect.close();
                if (stmtDeleteBooking != null) stmtDeleteBooking.close();
                if (stmtDeletePayment != null) stmtDeletePayment.close();
                if (con != null) con.close();
            } catch (Exception e) {
                System.out.println("Error closing resources: " + e.getMessage());
            }
        }
    }

    /**
     * Records a payment for a booking in the database.
     *
     * @param userId         ID of the user making the payment.
     * @param paymentDetails Details of the payment.
     * @param expiryDate     Expiry date of the payment method.
     * @param modeOfPayment  Mode of payment (e.g., net banking, credit card).
     * @return Transaction ID generated for the payment.
     * @throws BookingFailedException If the payment recording fails.
     */
    @Override
    public int makePayment(int userId, String paymentDetails, String expiryDate, String modeOfPayment) throws BookingFailedException {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int transactionId = 0;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish database connection
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/FlipFit", "root", "mysqliswow");

            String query = "INSERT INTO Payment (paymentDetails, expiryDate, modeOfPayment) VALUES (?, ?, ?)";
            stmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1, paymentDetails);
            stmt.setString(2, expiryDate);
            stmt.setString(3, modeOfPayment);

            int result = stmt.executeUpdate();
            if (result > 0) {
                // Retrieve the auto-generated transactionId
                rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                    transactionId = rs.getInt(1);
                    System.out.println("Generated transactionId: " + transactionId);
                }
                System.out.println("Payment successfully recorded.");
            } else {
                throw new BookingFailedException("Failed to record payment.");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (Exception e) {
                System.out.println("Error closing resources: " + e.getMessage());
            }
        }
        return transactionId;
    }
    //data interaction not data manipulation --> client -> service -> DAO
}
