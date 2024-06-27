package com.flipkart.dao;

import com.flipkart.business.BookingGymInterface;

import java.sql.*;

public class BookingGymDAOImpl implements BookingGymDAOInterface {

    @Override
    public void createBooking(int bookingId, int customerId, int gymId, int transactionId, String bookingDate, String bookingTimeSlot, String bookingType, int bookingAmount) {
        Connection con = null;
        PreparedStatement stmt = null;

        try {
            // Load the MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/FlipFit", "root", "Fk!@#%215023");

            // Query to insert a new booking
            String query = "INSERT INTO booking (bookingId, customerId, gymId, transactionId, bookingDate, bookingTimeSlot, bookingType, bookingAmount) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            stmt = con.prepareStatement(query);

            // Set the parameters
            stmt.setInt(1, bookingId);
            stmt.setInt(2, customerId);
            stmt.setInt(3, gymId);
            stmt.setInt(4, transactionId);
            stmt.setString(5, bookingDate);
            stmt.setString(6, bookingTimeSlot);
            stmt.setString(7, bookingType);
            stmt.setInt(8, bookingAmount);

            // Execute the update
            int rowsAffected = stmt.executeUpdate();

            // Check if the insertion was successful
            if (rowsAffected > 0) {
                System.out.println("Booking created successfully with ID " + bookingId);
            } else {
                System.out.println("Failed to create booking with ID " + bookingId);
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
