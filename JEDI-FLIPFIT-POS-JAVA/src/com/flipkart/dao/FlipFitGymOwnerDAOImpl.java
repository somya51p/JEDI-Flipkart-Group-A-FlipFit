package com.flipkart.dao;

import java.sql.*;

public class FlipFitGymOwnerDAOImpl implements FlipFitGymOwnerDAOInterface{
    @Override
    public void createGymOwner(int id, String name, String email, String phone, String address, String pan_no, String gst_no, String status) {
        
    }

    @Override
    public void editProfile(int id, String name, String email, String phone, String password, String address, String pan_no, String gst_no, String status) {

    }

    @Override
    public void registerGym(int gymId, String name, String location) {

    }

    @Override
    public void editGym(int gymId) {

    }

    @Override
    public void removeGym(int gymId) {

    }

    @Override
    public void viewAllRegisteredGymCenters() {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int ownerId = 101; // need to work on this

        try {

            Class.forName("com.mysql.jdbc.Driver");

            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/flipfit_schema", "root", "Fk!@#%215038");


            String query = "SELECT * FROM flipfitGym WHERE gymOwnerId = ?";
            stmt.setInt(1, ownerId);
            stmt = con.prepareStatement(query);


            rs = stmt.executeQuery();

            System.out.println("Gyms Registered to Owner " + ownerId);

            while (rs.next()) {
                int gymId = rs.getInt("gymId");
                int gymOwnerId = rs.getInt("gymOwnerId");
                String gymName = rs.getString("gymName");
                String gymLocation = rs.getString("gymLocation");

                System.out.println("Gym ID: " + gymId);
                System.out.println("Name: " + gymName);
                System.out.println("Location: " + gymLocation);
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
    public void viewAllBookings() {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int ownerId = 101; // need to work on this

        try {

            Class.forName("com.mysql.jdbc.Driver");

            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/flipfit_schema", "root", "Fk!@#%215038");

            String query = "SELECT * FROM booking b JOIN flipfitGym g ON b.gymId = g.gymId JOIN flipfitGymOwner go ON g.gymOwnerId = go.ownerId WHERE go.ownerId = ?";

            stmt.setInt(1, ownerId);
            stmt = con.prepareStatement(query);


            rs = stmt.executeQuery();

            System.out.println("All Bookings of Gyms Registered to Owner " + ownerId);

            while (rs.next()) {
                int bookingId = rs.getInt("bookingId");
                int customerId = rs.getInt("customerId");
                int gymId = rs.getInt("gymId");
                int transactionId = rs.getInt("transactionId");
                String date = rs.getString("bookingDate");
                String slot = rs.getString("bookingTimeSlot");
                String status = rs.getString("bookingType");
                int amount = rs.getInt("bookingAmount");

                System.out.println("Booking ID: " + bookingId);
                System.out.println("Customer ID: " + customerId);
                System.out.println("Gym ID: " + gymId);
                System.out.println("Transaction ID: " + transactionId);
                System.out.println("Booking Date: " + date);
                System.out.println("Booking Time Slot: " + slot);
                System.out.println("Booking Type: " + status);
                System.out.println("Booking Amount: " + amount);
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
    public void viewBookings(int gymId) {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {

            Class.forName("com.mysql.jdbc.Driver");

            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/flipfit_schema", "root", "Fk!@#%215038");

            String query = "SELECT * FROM booking WHERE gymId = ?";

            stmt.setInt(1, gymId);
            stmt = con.prepareStatement(query);


            rs = stmt.executeQuery();

            System.out.println("All Bookings of Gym " + gymId);

            while (rs.next()) {
                int bookingId = rs.getInt("bookingId");
                int customerId = rs.getInt("customerId");
                int transactionId = rs.getInt("transactionId");
                String date = rs.getString("bookingDate");
                String slot = rs.getString("bookingTimeSlot");
                String status = rs.getString("bookingType");
                int amount = rs.getInt("bookingAmount");

                System.out.println("Booking ID: " + bookingId);
                System.out.println("Customer ID: " + customerId);
                System.out.println("Transaction ID: " + transactionId);
                System.out.println("Booking Date: " + date);
                System.out.println("Booking Time Slot: " + slot);
                System.out.println("Booking Type: " + status);
                System.out.println("Booking Amount: " + amount);
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
    public void viewAvailableSlots(int gymId) {


    }

    @Override
    public void addSlot(int gymId, int slotId) {

    }

    @Override
    public void removeSlot(int gymId, int slotId) {

    }
}
