package com.flipkart.dao;

import java.sql.*;

public class FlipFitGymOwnerDAOImpl implements FlipFitGymOwnerDAOInterface{

    @Override
    public void createGymOwner(int userId, String name, String phone, String address, String pan_no, String gst_no) {
        Connection con = null;
        PreparedStatement stmtOwner = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/FlipFit", "root", "mysqliswow");
            con.setAutoCommit(false);

            String queryOwner = "INSERT INTO flipfitGymOwner (ownerName, ownerPhone, ownerAddress, ownerGSTNum, ownerPANNum, approvalStatus, userId) VALUES (?, ?, ?, ?, ?, ?, ?)";
            stmtOwner = con.prepareStatement(queryOwner);
            stmtOwner.setString(1, name);
            stmtOwner.setString(2, phone);
            stmtOwner.setString(3, address);
            stmtOwner.setString(4, gst_no);
            stmtOwner.setString(5, pan_no);
            stmtOwner.setString(6, "not approved");
            stmtOwner.setInt(7, userId);

            int ownerInsertCount = stmtOwner.executeUpdate();
            System.out.println(ownerInsertCount + " owner records inserted");

            con.commit();
        }catch(Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void editProfile(int ownerId, String ownerName, String ownerPhone, String ownerAddress, String ownerGstNum, String ownerPanNum, String approvalStatus) {
        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            // Establish a connection to the database
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/FlipFit", "root", "mysqliswow");

            // Prepare the SQL statement for updating the gym owner
            PreparedStatement ownerStmt = con.prepareStatement(
                    "UPDATE flipfitGymOwner SET ownerName=?, ownerPhone=?, ownerAddress=?, ownerGstNum=?, ownerPanNum=?, approvalStatus=? WHERE ownerId=?"
            );

            // Set the parameters for the prepared statement
            ownerStmt.setString(1, ownerName);
            ownerStmt.setString(2, ownerPhone);
            ownerStmt.setString(3, ownerAddress);
            ownerStmt.setString(4, ownerGstNum);
            ownerStmt.setString(5, ownerPanNum);
            ownerStmt.setString(6, approvalStatus);
            ownerStmt.setInt(7, ownerId);

            // Execute the update
            int ownerUpdateCount = ownerStmt.executeUpdate();
            System.out.println(ownerUpdateCount + " owner record(s) updated");

            // Close the connection
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void registerGym(int gymId, String name, String location) {
        Connection con = null;
        PreparedStatement stmtGym = null;

        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/FlipFit", "root", "mysqliswow");
            con.setAutoCommit(false);

            String queryGym = "INSERT INTO flipfitGym (gymId, gymOwnerId, gymName, gymLocation) VALUES (?, ?, ?, ?)";
            stmtGym = con.prepareStatement(queryGym);
            stmtGym.setInt(1, gymId);
            stmtGym.setInt(2, 1);  //need to work
            stmtGym.setString(3, name);
            stmtGym.setString(4, location);

            int gymInsertCount = stmtGym.executeUpdate();
            System.out.println(gymInsertCount + " user records inserted");

            con.commit();

        }catch (Exception e) {
            System.out.println(e);

        }
    }

    @Override
    public void editGym(int gymId, String gymName, String gymLocation) {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/FlipFit", "root", "mysqliswow");
            PreparedStatement gymStmt = con.prepareStatement(
                    "UPDATE flipfitGym SET gymName=?, gymLocation=? WHERE gymId=?"
            );

            gymStmt.setString(1, gymName);
            gymStmt.setString(2, gymLocation);
            gymStmt.setInt(3, gymId);

            int gymUpdateCount = gymStmt.executeUpdate();
            System.out.println(gymUpdateCount + " gym record(s) updated");

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void removeGym(int gymId) {

        Connection con = null;
        PreparedStatement stmt = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/FlipFit", "root", "mysqliswow");


            String query = "DELETE FROM flipfitGym WHERE gymId = ?";

            stmt = con.prepareStatement(query);
            stmt.setInt(1, gymId);

            int rowsAffected = stmt.executeUpdate();


            if (rowsAffected > 0) {
                System.out.println("Gym with ID " + gymId + " has been deleted.");

            } else {
                System.out.println("No gym found with ID " + gymId);

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
    public void viewAllRegisteredGymCenters() {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int ownerId = 101; // need to work on this

        try {

            Class.forName("com.mysql.jdbc.Driver");

            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/FlipFit", "root", "mysqliswow");


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
                    "jdbc:mysql://localhost:3306/FlipFit", "root", "mysqliswow");

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
                    "jdbc:mysql://localhost:3306/FlipFit", "root", "mysqliswow");

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
    public void addSlot(int gymId, int slotId, String slotTime, int slotCapacity) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/FlipFit", "root", "mysqliswow");
            PreparedStatement slotStmt = con.prepareStatement(
                    "INSERT INTO slot (slotId, gymId, slotTime, slotCapacity) VALUES (?, ?, ?, ?)"
            );

            slotStmt.setInt(1, slotId);
            slotStmt.setInt(2, gymId);
            slotStmt.setString(3, slotTime);
            slotStmt.setInt(4, slotCapacity);

            int slotInsertCount = slotStmt.executeUpdate();
            System.out.println(slotInsertCount + " slot record(s) inserted");
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    @Override
    public void removeSlot(int slotId) {
        Connection con = null;
        PreparedStatement stmt = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/FlipFit", "root", "mysqliswow");


            String query = "DELETE FROM Slot WHERE slotId = ?";

            stmt = con.prepareStatement(query);
            stmt.setInt(1, slotId);

            int rowsAffected = stmt.executeUpdate();


            if (rowsAffected > 0) {
                System.out.println("slot with ID " + slotId + " has been deleted.");

            } else {
                System.out.println("No slot found with ID " + slotId);

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
}