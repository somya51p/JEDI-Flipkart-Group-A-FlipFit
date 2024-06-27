package com.flipkart.dao;

import java.sql.*;

public class FlipFitCustomerDAOImpl implements FlipFitCustomerDAOInterface {

//    public static void main(String[] args) {
//        FlipFitCustomerDAOInterface dao = new FlipFitCustomerDAOImpl();
//        //dao.createCustomer(1, 1, "John Doe", "1111111111", "abc", "john.doe@example.com", "somya");
//        dao.editProfile(1, "Sarthak Doe", "1111111111", "abc");
//    }

    @Override
    public void createCustomer(int customerId, int userId, String name, String phoneNumber, String address, String userEmail, String userPass) {
        Connection con = null;
        PreparedStatement stmtUser = null;
        PreparedStatement stmtCustomer = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");

            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/flipfit_schema", "root", "Fk!@#%215020");

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
        public void editProfile(int customerId, String customerName, String customerPhone, String customerAddress) {
            try {
                // Load MySQL JDBC driver
                Class.forName("com.mysql.jdbc.Driver");

                // Establish a connection to the database
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/flipfit_schema", "root", "Fk!@#%215020");

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

    }

    @Override
    public void viewSlots() {

    }

    @Override
    public void filterSlots() {

    }
}
