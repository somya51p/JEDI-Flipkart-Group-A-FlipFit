package com.flipkart.dao;

import com.flipkart.business.BookingGymInterface;

import java.sql.*;

public class BookingGymDAOImpl implements BookingGymDAOInterface {

    public static void main(String[] args) {
        BookingGymDAOInterface dao= new BookingGymDAOImpl();
        dao.createBooking(1, 1, 150, 250, "02-03-24","5", "confirmed", 500);
        dao.makePayment(2, 1111333333, "12/25", "net banking");
        dao.cancelBookings(2);
    }

    @Override
    public void createBooking(int bookingId, int customerId, int gymId, int transactionId, String bookingDate, String bookingTimeSlot, String bookingType, int bookingAmount) {
        Connection con = null;
        PreparedStatement stmt = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/FlipFit", "root", "mysqliswow");

            String query = "INSERT INTO booking (bookingId, customerId, gymId, transactionId, bookingDate, bookingTimeSlot, bookingType, bookingAmount) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            stmt = con.prepareStatement(query);

            stmt.setInt(1, bookingId);
            stmt.setInt(2, customerId);
            stmt.setInt(3, gymId);
            stmt.setInt(4, transactionId);
            stmt.setString(5, bookingDate);
            stmt.setString(6, bookingTimeSlot);
            stmt.setString(7, bookingType);
            stmt.setInt(8, bookingAmount);

            int rowsAffected = stmt.executeUpdate();

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
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {

            Class.forName("com.mysql.jdbc.Driver");

            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/FlipFit", "root", "mysqliswow");

            String query = "SELECT * FROM booking";
            stmt = con.prepareStatement(query);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int bookingId = rs.getInt("bookingId");
                int customerId = rs.getInt("customerId");
                int gymId = rs.getInt("gymId");
                int transactionId = rs.getInt("transactionId");
                String bookingDate = rs.getString("bookingDate");
                String bookingTimeSlot = rs.getString("bookingTimeSlot");
                String bookingType = rs.getString("bookingType");
                int bookingAmount = rs.getInt("bookingAmount");

                System.out.println("Booking ID: " + bookingId);
                System.out.println("Customer ID: " + customerId);
                System.out.println("Gym ID: " + gymId);
                System.out.println("Transaction ID: " + transactionId);
                System.out.println("Booking Date: " + bookingDate);
                System.out.println("Booking TimeSlot: " + bookingTimeSlot);
                System.out.println("Booking Type: " + bookingType);
                System.out.println("Booking Amount: " + bookingAmount);
                System.out.println("=================================");
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
    }

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

    @Override
    public void makePayment(int transactionId, int cardNumber, String expiryDate, String modeOfPayment) {
        Connection con = null;
        PreparedStatement stmt = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/FlipFit", "root", "mysqliswow");

            String query = "INSERT INTO Payment (transactionId, cardNumber, expiryDate, modeOfPayment) VALUES (?, ?, ?, ?)";
            stmt = con.prepareStatement(query);

            stmt.setInt(1, transactionId);
            stmt.setInt(2, cardNumber);
            stmt.setString(3, expiryDate);
            stmt.setString(4, modeOfPayment);

            int result = stmt.executeUpdate();
            if (result > 0) {
                System.out.println("Payment successfully recorded.");
            } else {
                System.out.println("Failed to record payment.");
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
    //data interaction not data manipulation --> client -> service -> DAO
}
