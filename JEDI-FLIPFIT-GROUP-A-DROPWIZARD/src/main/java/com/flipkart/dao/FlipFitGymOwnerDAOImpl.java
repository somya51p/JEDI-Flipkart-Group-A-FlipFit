package com.flipkart.dao;

import com.flipkart.bean.Booking;
import com.flipkart.bean.FlipFitGym;
import com.flipkart.bean.Slot;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FlipFitGymOwnerDAOImpl implements FlipFitGymOwnerDAOInterface{
    /**
     * Creates a new gym owner in the database.
     * @param userId The ID of the user to be associated with the gym owner.
     * @param name The name of the gym owner.
     * @param phone The phone number of the gym owner.
     * @param address The address of the gym owner.
     * @param pan_no The PAN number of the gym owner.
     * @param gst_no The GST number of the gym owner.
     */
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

    /**
     * Edits the profile of an existing gym owner in the database.
     * @param userId The ID of the gym owner.
     * @param ownerName The updated name of the gym owner.
     * @param ownerPhone The updated phone number of the gym owner.
     * @param ownerAddress The updated address of the gym owner.
     * @param ownerGstNum The updated GST number of the gym owner.
     * @param ownerPanNum The updated PAN number of the gym owner.
     */
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
    /**
     * Registers a new gym owned by the current gym owner.
     * @param userId The ID of the gym owner.
     * @param name The name of the gym to be registered.
     * @param location The location of the gym to be registered.
     */
    @Override
    public void registerGym(int userId, String name, String location) {

        Connection con = null;
        PreparedStatement stmt = null;
        PreparedStatement stmtGym = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/FlipFit", "root", "mysqliswow");

            // First, get the ownerId from the userId
            String ownerQuery = "SELECT ownerId FROM flipfitGymOwner WHERE userId = ?";
            stmt = con.prepareStatement(ownerQuery);
            stmt.setInt(1, userId);
            rs = stmt.executeQuery();

            int ownerId = -1;
            if (rs.next()) {
                ownerId = rs.getInt("ownerId");
            } else {
                System.out.println("No customer found with userId: " + userId);
            }

            rs.close();
            stmt.close();

            String queryGym = "INSERT INTO flipfitGym (gymOwnerId, gymName, gymLocation) VALUES (?, ?, ?);";
            stmtGym = con.prepareStatement(queryGym);
            stmtGym.setInt(1, ownerId);
            stmtGym.setString(2, name);
            stmtGym.setString(3, location);

            int ownerInsertCount = stmtGym.executeUpdate();
            System.out.println(ownerInsertCount + " gym records inserted");

            con.commit();


        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmtGym != null) stmtGym.close();
                if (con != null) con.close();
            } catch (Exception e) {
                System.out.println("Error closing resources: " + e.getMessage());
            }
        }
    }

    /**
     * Edits the details of an existing gym.
     * @param gymId The ID of the gym to be edited.
     * @param gymName The updated name of the gym.
     * @param gymLocation The updated location of the gym.
     */
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

    /**
     * Removes a gym from the database.
     * @param gymId The ID of the gym to be removed.
     */
    @Override
    public void removeGym(int gymId) {
        Connection con = null;
        PreparedStatement stmt = null;
        int count;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/FlipFit", "root", "mysqliswow");

            String gymQuery = "DELETE FROM flipfitGym WHERE gymId=?";
            stmt = con.prepareStatement(gymQuery);
            stmt.setInt(1, gymId);
            count = stmt.executeUpdate();

            stmt.close();

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

    /**
     * Retrieves a list of all gyms registered by the current gym owner.
     * @param userId The ID of the gym owner.
     * @return A list of FlipFitGym objects representing all registered gyms.
     */

    @Override
    public List<FlipFitGym> viewAllRegisteredGymCenters(int userId) {

        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<FlipFitGym> gymList = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/FlipFit", "root", "mysqliswow");

            // First, get the ownerId from the userId
            String ownerQuery = "SELECT ownerId FROM flipfitGymOwner WHERE userId = ?";
            stmt = con.prepareStatement(ownerQuery);
            stmt.setInt(1, userId);
            rs = stmt.executeQuery();

            int ownerId = -1;
            if (rs.next()) {
                ownerId = rs.getInt("ownerId");
            } else {
                System.out.println("No customer found with userId: " + userId);
                return gymList; // return empty list if no customer found
            }

            rs.close();
            stmt.close();

            String gymQuery = "SELECT * FROM flipfitGym WHERE gymOwnerId = ?";
            stmt = con.prepareStatement(gymQuery);
            stmt.setInt(1, ownerId);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int gymId = rs.getInt("gymId");
                ownerId = rs.getInt("gymOwnerId");
                String gymName = rs.getString("gymName");
                String gymLocation = rs.getString("gymLocation");

                FlipFitGym gym = new FlipFitGym(gymId, ownerId, gymName, gymLocation);
                gymList.add(gym);
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

    /**
     * Retrieves a list of all bookings made at gyms owned by the current gym owner.
     * @param userId The ID of the gym owner.
     * @return A list of Booking objects representing all bookings.
     */

    @Override
    public List<Booking> viewAllBookings(int userId) {

        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Booking> bookings = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/FlipFit", "root", "mysqliswow");

            // First, get the ownerId from the userId
            String customerQuery = "SELECT ownerId FROM flipfitGymOwner WHERE userId = ?";
            stmt = con.prepareStatement(customerQuery);
            stmt.setInt(1, userId);
            rs = stmt.executeQuery();

            int ownerId = -1;
            if (rs.next()) {
                ownerId = rs.getInt("ownerId");
            } else {
                System.out.println("No customer found with userId: " + userId);
                return bookings;
            }

            rs.close();
            stmt.close();

            String bookingQuery = "SELECT * FROM booking b JOIN flipfitGym g ON b.gymId = g.gymId JOIN flipfitGymOwner go ON g.gymOwnerId = go.ownerId WHERE go.ownerId = ?";
            stmt = con.prepareStatement(bookingQuery);
            stmt.setInt(1, ownerId);
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
     * Retrieves a list of bookings for a specific gym owned by the current gym owner.
     * @param gymId The ID of the gym.
     * @return A list of Booking objects representing bookings at the gym.
     */
    @Override
    public List<Booking> viewBookings(int gymId) {

        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Booking> bookings = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/FlipFit", "root", "mysqliswow");

            // Now, get all bookings for the gymId
            String bookingQuery = "SELECT * FROM booking WHERE gymId = ?";
            stmt = con.prepareStatement(bookingQuery);
            stmt.setInt(1, gymId);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int bookingId = rs.getInt("bookingId");
                int customerId = rs.getInt("customerId");
                gymId = rs.getInt("gymId");
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
     * Retrieves a list of available slots for a specific gym.
     * @param gymId The ID of the gym.
     * @return A list of Slot objects representing available slots at the gym.
     */
    @Override
    public List<Slot> viewAvailableSlots(int gymId) {
        List<Slot> slotList = new ArrayList<Slot>();

        return slotList;

    }

    /**
     * Adds a new slot for booking at a specific gym.
     * @param gymId The ID of the gym.
     * @param slotId The ID of the slot.
     * @param slotTime The time of the slot.
     * @param slotCapacity The capacity of the slot.
     * @param slotPrice The price of the slot.
     */
    @Override
    public void addSlot(int gymId, int slotId, String slotTime, int slotCapacity, int slotPrice) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/FlipFit", "root", "mysqliswow");
            PreparedStatement slotStmt = con.prepareStatement(
                    "INSERT INTO slot (slotId, gymId, slotTime, slotCapacity, slotPrice) VALUES (?, ?, ?, ?, ?)"
            );

            slotStmt.setInt(1, slotId);
            slotStmt.setInt(2, gymId);
            slotStmt.setString(3, slotTime);
            slotStmt.setInt(4, slotCapacity);
            slotStmt.setInt(5, slotPrice);

            int slotInsertCount = slotStmt.executeUpdate();
            System.out.println(slotInsertCount + " slot record(s) inserted");
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    /**
     * Removes a slot from booking availability at a specific gym.
     * @param gymId The ID of the gym.
     * @param slotId The ID of the slot to be removed.
     */
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