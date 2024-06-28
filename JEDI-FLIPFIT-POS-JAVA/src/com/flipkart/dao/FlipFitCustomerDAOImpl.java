package com.flipkart.dao;
import com.flipkart.exceptions.UserNotFoundException;
import java.sql.*;

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
    public void createCustomer(int customerId, int userId, String name, String phoneNumber, String address, String userEmail, String userPass) {
        Connection con = null;
        PreparedStatement stmtUser = null;
        PreparedStatement stmtCustomer = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");

            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/FlipFit", "root", "mysqliswow");

            con.setAutoCommit(false); // Start transaction

            // Insert into users table first
            String queryUser = "INSERT INTO users (userId, userEmail, userPassword, roleId) VALUES (?, ?, ?, ?)";
            stmtUser = con.prepareStatement(queryUser);

            stmtUser.setInt(1, userId);
            stmtUser.setString(2, userEmail);
            stmtUser.setString(3, userPass);
            stmtUser.setInt(4, 1);

            int userInsertCount = stmtUser.executeUpdate();
            System.out.println(userInsertCount + " user records inserted");

            // Insert into flipfitCustomer table
            String queryCustomer = "INSERT INTO flipfitCustomer (customerId, customerName, customerPhone, customerAddress, userId) VALUES (?, ?, ?, ?, ?)";
            stmtCustomer = con.prepareStatement(queryCustomer);

            stmtCustomer.setInt(1, customerId);
            stmtCustomer.setString(2, name);
            stmtCustomer.setString(3, phoneNumber);
            stmtCustomer.setString(4, address);
            stmtCustomer.setInt(5, userId);

            int customerInsertCount = stmtCustomer.executeUpdate();
            System.out.println(customerInsertCount + " customer records inserted");

            con.commit(); // Commit transaction
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
        public void editProfile (int customerId, String customerName, String customerPhone, String customerAddress) throws UserNotFoundException{
            try {
                // Load MySQL JDBC driver
                Class.forName("com.mysql.jdbc.Driver");

                // Establish a connection to the database
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/flipfit_schema", "root", "Fk!@#%215038");
                
                // Update the Customer table
                PreparedStatement customerStmt = con.prepareStatement("UPDATE flipfitCustomer SET customerName=?, customerPhone=?, customerAddress=? WHERE customerId=?");
                customerStmt.setString(1, customerName);
                customerStmt.setString(2, customerPhone);
                customerStmt.setString(3, customerAddress);
                customerStmt.setInt(4, customerId);

                // Execute the customer update
                int customerUpdateCount = customerStmt.executeUpdate();
               

                // If no rows are updated, throw a custom exception
                if (customerUpdateCount == 0) {
                    throw new UserNotFoundException("Customer with customerId "+customerId+" does not exist");
                }
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

            String querySlots = "SELECT * FROM slot WHERE gymId = ?";
            stmtSlots = con.prepareStatement(querySlots);
            stmtSlots.setInt(1, gymId);
            rsSlots = stmtSlots.executeQuery();

            while (rsSlots.next()) {
                int slotId = rsSlots.getInt("slotId");
                String slotTime = rsSlots.getString("slotTime");

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
