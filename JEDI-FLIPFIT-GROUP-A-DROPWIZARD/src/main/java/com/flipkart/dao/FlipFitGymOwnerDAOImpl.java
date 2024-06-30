package com.flipkart.dao;

import com.flipkart.bean.Booking;
import com.flipkart.bean.FlipFitGym;
import com.flipkart.bean.Slot;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
    public void editProfile(int userId, String ownerName, String ownerPhone, String ownerAddress, String ownerGstNum, String ownerPanNum) {
        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            // Establish a connection to the database
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/FlipFit", "root", "mysqliswow");

            // Prepare the SQL statement for updating the gym owner
            PreparedStatement ownerStmt = con.prepareStatement(
                    "UPDATE flipfitGymOwner SET ownerName=?, ownerPhone=?, ownerAddress=?, ownerGstNum=?, ownerPanNum=? WHERE userId=?"
            );

            // Set the parameters for the prepared statement
            ownerStmt.setString(1, ownerName);
            ownerStmt.setString(2, ownerPhone);
            ownerStmt.setString(3, ownerAddress);
            ownerStmt.setString(4, ownerGstNum);
            ownerStmt.setString(5, ownerPanNum);
            ownerStmt.setInt(6, userId);

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
    public void registerGym(int userId, String name, String location) {
        Connection con = null;
        PreparedStatement stmt = null;
        PreparedStatement stmtGym = null;
        ResultSet rs = null;
        int gymOwnerId = 0;

        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/FlipFit", "root", "mysqliswow");
            con.setAutoCommit(false);

            String query = "SELECT ownerId FROM flipfitGymOwner WHERE userId = ?";
            stmt.setInt(1, userId);
            stmt = con.prepareStatement(query);

            rs = stmt.executeQuery();

            while (rs.next()) {
                gymOwnerId = rs.getInt("ownerId");

            }
            String queryGym = "INSERT INTO flipfitGym (gymOwnerId, gymName, gymLocation) VALUES ( ?, ?, ?)";
            stmtGym = con.prepareStatement(queryGym);
            stmtGym.setInt(1, gymOwnerId);  //need to work
            stmtGym.setString(2, name);
            stmtGym.setString(3, location);

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
    public List<FlipFitGym> viewAllRegisteredGymCenters(int userId) {
        Connection con = null;
        PreparedStatement stmt = null;
        PreparedStatement stmtowner = null;
        ResultSet rs = null;
        ResultSet rs1 = null;
        int gymOwnerId = 0; // need to work on this
        List<FlipFitGym> gymList = new ArrayList<FlipFitGym>();

        try {

            Class.forName("com.mysql.jdbc.Driver");

            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/FlipFit", "root", "mysqliswow");

            String queryOwner = "SELECT ownerId FROM flipfitGymOwner WHERE userId = ?";
            stmtowner.setInt(1, userId);
            stmtowner = con.prepareStatement(queryOwner);

            rs1 = stmtowner.executeQuery();

            while (rs1.next()) {
                gymOwnerId = rs1.getInt("ownerId");

            }

            String query = "SELECT * FROM flipfitGym WHERE gymOwnerId = ?";
            stmt.setInt(1, gymOwnerId);
            stmt = con.prepareStatement(query);

            rs = stmt.executeQuery();

            System.out.println("Gyms Registered to Owner " + gymOwnerId);

            while (rs.next()) {
                int gymId = rs.getInt("gymId");
                int ownerId = rs.getInt("ownerId");
                String gymName = rs.getString("gymName");
                String gymLocation = rs.getString("gymLocation");
                gymList.add(new FlipFitGym(gymId, ownerId, gymName, gymLocation));

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

        return gymList;

    }

    @Override
    public List<Booking> viewAllBookings(int userId) {
        Connection con = null;
        PreparedStatement stmt = null;
        PreparedStatement stmtowner = null;
        ResultSet rs = null;
        ResultSet rs1 = null;
        int gymOwnerId = 0; // need to work on this
        List<Booking> bookings = new ArrayList<Booking>();

        try {

            Class.forName("com.mysql.jdbc.Driver");

            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/FlipFit", "root", "mysqliswow");

            String queryOwner = "SELECT ownerId FROM flipfitGymOwner WHERE userId = ?";
            stmtowner.setInt(1, userId);
            stmtowner = con.prepareStatement(queryOwner);

            rs1 = stmtowner.executeQuery();

            while (rs1.next()) {
                gymOwnerId = rs1.getInt("ownerId");

            }
            String query = "SELECT * FROM booking b JOIN flipfitGym g ON b.gymId = g.gymId JOIN flipfitGymOwner go ON g.gymOwnerId = go.ownerId WHERE go.ownerId = ?";

            stmt.setInt(1, gymOwnerId);
            stmt = con.prepareStatement(query);


            rs = stmt.executeQuery();

            System.out.println("All Bookings of Gyms Registered to Owner " + gymOwnerId);

            while (rs.next()) {
                int bookingId = rs.getInt("bookingId");
                int customerId = rs.getInt("customerId");
                int gymId = rs.getInt("gymId");
                int transactionId = rs.getInt("transactionId");
                String date = rs.getString("bookingDate");
                String slot = rs.getString("bookingTimeSlot");
                String status = rs.getString("bookingType");
                int amount = rs.getInt("bookingAmount");

                bookings.add(new Booking(bookingId, customerId, gymId, transactionId, date, slot, status, amount));
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

    @Override
    public List<Booking> viewBookings(int gymId) {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Booking> bookings = new ArrayList<Booking>();
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
                gymId = rs.getInt("gymId");
                int transactionId = rs.getInt("transactionId");
                String date = rs.getString("bookingDate");
                String slot = rs.getString("bookingTimeSlot");
                String status = rs.getString("bookingType");
                int amount = rs.getInt("bookingAmount");

                bookings.add(new Booking(bookingId, customerId, gymId, transactionId, date, slot, status, amount));
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

    @Override
    public List<Slot> viewAvailableSlots(int gymId) {
        List<Slot> slotList = new ArrayList<Slot>();

        return slotList;

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
    public void removeSlot(int gymId, int slotId) {
        Connection con = null;
        PreparedStatement stmt = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/FlipFit", "root", "mysqliswow");


            String query = "DELETE FROM Slot WHERE slotId = ? and gymId = ?";

            stmt = con.prepareStatement(query);
            stmt.setInt(1, slotId);
            stmt.setInt(2, gymId);


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