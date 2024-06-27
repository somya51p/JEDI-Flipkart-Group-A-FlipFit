package com.flipkart.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class FlipFitGymOwnerDAOImpl implements FlipFitGymOwnerDAOInterface{

//        public static void main(String[] args) {
//        FlipFitGymOwnerDAOInterface dao = new FlipFitGymOwnerDAOImpl();
//        //dao.createGymOwner(1, 2, "John Doe", "1111111111", "abc", "6y4r874ybddjik", "hdsuw3yd636","gdwy","bhwj");
//        //dao.registerGym(2,"bdwh","sg");
//        dao.editGym(2,"gegw","hduywg");
//    }


    @Override
    public void createGymOwner(int gymOwnerId, int userId, String name, String phone, String address, String pan_no, String gst_no, String userEmail, String userPass) {
        Connection con = null;
        PreparedStatement stmtUser = null;
        PreparedStatement stmtOwner = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/flipfit_schema", "root", "Fk!@#%215020");
            con.setAutoCommit(false);

            String queryUser = "INSERT INTO users (userId, userEmail, userPassword, roleId) VALUES (?, ?, ?, ?)";
            stmtUser = con.prepareStatement(queryUser);
            stmtUser.setInt(1, userId);
            stmtUser.setString(2, userEmail);
            stmtUser.setString(3, userPass);
            stmtUser.setInt(4, 2);

            int userInsertCount = stmtUser.executeUpdate();
            System.out.println(userInsertCount + " user records inserted");

            String queryOwner = "INSERT INTO flipfitGymOwner (ownerId, ownerName, ownerPhone, ownerAddress, ownerGSTNum, ownerPANNum, approvalStatus, userId) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            stmtOwner = con.prepareStatement(queryOwner);
            stmtOwner.setInt(1, gymOwnerId);
            stmtOwner.setString(2, name);
            stmtOwner.setString(3, phone);
            stmtOwner.setString(4, address);
            stmtOwner.setString(5, gst_no);
            stmtOwner.setString(6, pan_no);
            stmtOwner.setString(7, "not approved");
            stmtOwner.setInt(8, userId);

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
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/flipfit_schema", "root", "Fk!@#%215020");

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
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/flipfit_schema", "root", "Fk!@#%215020");
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

                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/flipfit_schema", "root", "Fk!@#%215020");
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

    }

    @Override
    public void viewAllRegisteredGymCenters() {

    }

    @Override
    public void viewAllBookings() {

    }

    @Override
    public void viewBookings(int gymId) {

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
