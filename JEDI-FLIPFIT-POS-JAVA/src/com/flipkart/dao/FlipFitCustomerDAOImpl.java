package com.flipkart.dao;

import java.sql.*;

public class FlipFitCustomerDAOImpl implements FlipFitCustomerDAOInterface {

    @Override
    public void createCustomer(int userId, String name, String phoneNumber, String address) {
        Connection con = null;
        PreparedStatement stmtCustomer = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/FlipFit", "root", "Fk!@#%215023");
            con.setAutoCommit(false);

            String queryCustomer = "INSERT INTO flipfitCustomer (customerName, customerPhone, customerAddress, userId) VALUES (?, ?, ?, ?)";
            stmtCustomer = con.prepareStatement(queryCustomer);

            stmtCustomer.setString(1, name);
            stmtCustomer.setString(2, phoneNumber);
            stmtCustomer.setString(3, address);
            stmtCustomer.setInt(4, userId);

            int customerInsertCount = stmtCustomer.executeUpdate();
            System.out.println(customerInsertCount + " owner records inserted");

            con.commit(); // Commit transaction
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
        public void editProfile(int customerId, String customerName, String customerPhone, String customerAddress) {
            try {
                // Load MySQL JDBC driver
                Class.forName("com.mysql.jdbc.Driver");

                // Establish a connection to the database
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/FlipFit", "root", "Fk!@#%215023");

                // Update the Customer table
                PreparedStatement customerStmt = con.prepareStatement("UPDATE flipfitCustomer SET customerName=?, customerPhone=?, customerAddress=? WHERE customerId=?");
                customerStmt.setString(1, customerName);
                customerStmt.setString(2, customerPhone);
                customerStmt.setString(3, customerAddress);
                customerStmt.setInt(4, customerId);

                // Execute the customer update
                int customerUpdateCount = customerStmt.executeUpdate();
                System.out.println(customerUpdateCount + " customer record(s) updated");

                // Close the connection
                con.close();

            } catch (Exception e) {
                System.out.println(e);
            }
        }

    @Override
    public void viewGyms() {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/flipfit", "root", "mysqliswow");

            String query = "SELECT * FROM flipfitGym";
            stmt = con.prepareStatement(query);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("gymId");
                int ownerId = rs.getInt("gymOwnerId");
                String gymName = rs.getString("gymName");
                String gymLocation = rs.getString("gymLocation");

                System.out.println("ID: " + id);
                System.out.println("Gym Owner Id: " + ownerId);
                System.out.println("Gym Name: " + gymName);
                System.out.println("Gym Location: " + gymLocation);
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
    public void viewSlots(int gymId, String date) {
        // TODO: not complete implementation
        Connection con = null;
        PreparedStatement stmtSlots = null;
        PreparedStatement stmtBookings = null;
        ResultSet rsSlots = null;
        ResultSet rsBookings = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/flipfit", "root", "mysqliswow");

            // Step 1: Retrieve all slots for the given gymId
            String querySlots = "SELECT * FROM slot WHERE gymId = ?";
            stmtSlots = con.prepareStatement(querySlots);
            stmtSlots.setInt(1, gymId);
            rsSlots = stmtSlots.executeQuery();

            while (rsSlots.next()) {
                int slotId = rsSlots.getInt("slotId");
                String slotTime = rsSlots.getString("slotTime");

                // Step 2: Count how many slots are already booked for the given gymId and date
                String queryBookings = "SELECT COUNT(*) as bookedCount FROM Booking WHERE gymId = ? AND bookingDate = ? AND bookingTimeSlot = ?";
                stmtBookings = con.prepareStatement(queryBookings);
                stmtBookings.setInt(1, gymId);
                stmtBookings.setString(2, date);
                stmtBookings.setString(3, slotTime);
                rsBookings = stmtBookings.executeQuery();

                int bookedCount = 0;
                if (rsBookings.next()) {
                    bookedCount = rsBookings.getInt("bookedCount");
                }

                System.out.println("Slot ID: " + slotId);
                System.out.println("Slot Time: " + slotTime);
                System.out.println("Booked Count: " + bookedCount);
                System.out.println("=================================");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                if (rsBookings != null) rsBookings.close();
                if (stmtBookings != null) stmtBookings.close();
                if (rsSlots != null) rsSlots.close();
                if (stmtSlots != null) stmtSlots.close();
                if (con != null) con.close();
            } catch (Exception e) {
                System.out.println("Error closing resources: " + e.getMessage());
            }
        }
    }

    @Override
    public void filterSlots() {

    }
}
