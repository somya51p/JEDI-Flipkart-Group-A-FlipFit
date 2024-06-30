package com.flipkart.dao;
import com.flipkart.bean.FlipFitGym;
import com.flipkart.bean.Slot;
import com.flipkart.exceptions.GymNotFoundException;
import com.flipkart.exceptions.UserNotFoundException;
import java.sql.*;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

public class FlipFitCustomerDAOImpl implements FlipFitCustomerDAOInterface {

    public static void main(String[] args) {
        FlipFitCustomerDAOInterface dao = new FlipFitCustomerDAOImpl();
        //dao.createCustomer(1, 1, "John Doe", "1111111111", "abc", "john.doe@example.com", "somya");
//        dao.editProfile(1, "Sarthak Doe", "1111111111", "abc");
//        dao.viewGyms();
//        dao.viewSlots(1, "12-12-12");
        try {
            dao.editProfile(11, null, null, null);
        } catch (UserNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
    public void createCustomer(int userId, String name, String phoneNumber, String address) {
        Connection con = null;
        PreparedStatement stmtCustomer = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/FlipFit", "root", "mysqliswow");
            con.setAutoCommit(false);

            String queryCustomer = "INSERT INTO flipfitCustomer (customerName, customerPhone, customerAddress, userId) VALUES (?, ?, ?, ?)";
            stmtCustomer = con.prepareStatement(queryCustomer);

            stmtCustomer.setString(1, name);
            stmtCustomer.setString(2, phoneNumber);
            stmtCustomer.setString(3, address);
            stmtCustomer.setInt(4, userId);

            int customerInsertCount = stmtCustomer.executeUpdate();
            System.out.println(customerInsertCount + " customer records inserted");

            con.commit(); // Commit transaction
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void editProfile(int userId, String name, String phoneNumber, String address) throws UserNotFoundException{
        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            // Establish a connection to the database
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/FlipFit", "root", "mysqliswow");

            // Update the Customer table
            PreparedStatement customerStmt = con.prepareStatement("UPDATE flipfitCustomer SET customerName=?, customerPhone=?, customerAddress=? WHERE userId=?");
            customerStmt.setString(1, name);
            customerStmt.setString(2, phoneNumber);
            customerStmt.setString(3, address);
            customerStmt.setInt(4, userId);

            // Execute the customer update
            int customerUpdateCount = customerStmt.executeUpdate();

            // If no rows are updated, throw a custom exception
            if (customerUpdateCount == 0) {
                throw new UserNotFoundException("Customer with user id "+userId+" does not exist");
            }
            System.out.println(customerUpdateCount + " customer record(s) updated");

            // Close the connection
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public List<FlipFitGym> viewGyms() {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<FlipFitGym> gymList = new ArrayList<FlipFitGym>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/FlipFit", "root", "mysqliswow");

            String query = "SELECT * FROM flipfitGym";
            stmt = con.prepareStatement(query);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int gymId = rs.getInt("gymId");
                int ownerId = rs.getInt("gymOwnerId");
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
    public HashMap<String, Integer> viewSlots(int gymId, String date) throws GymNotFoundException {
        Connection con = null;
        PreparedStatement stmtSlots = null;
        PreparedStatement stmtBookings = null;
        ResultSet rsSlots = null;
        ResultSet rsBookings = null;
        HashMap<String, Integer> slotAvailability = new HashMap<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/FlipFit", "root", "mysqliswow");

            String querySlots = "SELECT * FROM slot WHERE gymId = ?";
            stmtSlots = con.prepareStatement(querySlots);
            stmtSlots.setInt(1, gymId);
            rsSlots = stmtSlots.executeQuery();

            if (!rsSlots.isBeforeFirst()) {
                throw new GymNotFoundException(gymId);
            }

            while (rsSlots.next()) {
                int slotId = rsSlots.getInt("slotId");
                String slotTime = rsSlots.getString("slotTime");
                int slotCapacity = rsSlots.getInt("slotCapacity");

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
                int availableSeats = slotCapacity - bookedCount;
                slotAvailability.put(slotTime,availableSeats);
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

        return slotAvailability;
    }


    @Override
    public void filterSlots() {

    }
}
