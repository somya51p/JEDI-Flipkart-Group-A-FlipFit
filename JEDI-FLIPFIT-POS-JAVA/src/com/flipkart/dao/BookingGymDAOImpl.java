package com.flipkart.dao;

import com.flipkart.bean.Booking;
import com.flipkart.exceptions.GymNotFoundException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookingGymDAOImpl implements BookingGymDAOInterface {

//    public static void main(String[] args) {
//        BookingGymDAOInterface dao= new BookingGymDAOImpl();
//        dao.createBooking(1, 1, 150, 250, "02-03-24","5", "confirmed", 500);
//
//    }

    @Override
    public void createBooking(int bookingId, int customerId, int gymId, int transactionId, String bookingDate, String bookingTimeSlot, String bookingType, int bookingAmount) {
        Connection con = null;
        PreparedStatement stmt = null;

        try {
            // Load the MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/FlipFit", "root", "mysqliswow");

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
    public List<Booking> viewBookings() {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Booking> bookings = new ArrayList<>();
        return bookings;
    }

    @Override
    public void cancelBookings() {

    }

    @Override
    public void makePayment() {

    }

    @Override
    public boolean isGymAvailable(int gymId) throws GymNotFoundException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/FlipFit", "root", "mysqliswow");

            // Prepare SQL statement to check if gymId exists in FlipFitGym table
            String query = "SELECT COUNT(*) FROM flipfitGym WHERE gymId = ?";
            stmt = con.prepareStatement(query);
            stmt.setInt(1, gymId);

            // Execute the query
            rs = stmt.executeQuery();

            // Check if any rows are returned and if the gymId exists
            if (rs.next()) {
                int count = rs.getInt(1);
                if (count > 0) {
                    return true;
                } else {
                    throw new GymNotFoundException(gymId);
                }
            }

            throw new GymNotFoundException(gymId); // Gym with gymId not found
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            // Close ResultSet, PreparedStatement, and handle exceptions
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                throw new RuntimeException("Error closing resources in isGymAvailable: " + e.getMessage(), e);
            }
        }
    }
    //data interaction not data manipulation --> client -> service -> DAO
}
