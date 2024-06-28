package com.flipkart.dao;

import com.flipkart.bean.FlipFitGymOwner;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FlipfitAdminDAOImpl implements FlipfitAdminDAOInterface{

    @Override
    public void createAdmin(int adminId, String adminEmail, String adminPassword) {}

    @Override
    public List<FlipFitGymOwner> viewAllGymOwners() {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<String> Output= new ArrayList<>();

        List<FlipFitGymOwner> gymOwnerList = new ArrayList<FlipFitGymOwner>();

        try {

            Class.forName("com.mysql.jdbc.Driver");

            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/FlipFit", "root", "mysqliswow");

            String query = "SELECT * FROM flipfitGymOwner";

            stmt = con.prepareStatement(query);
            rs = stmt.executeQuery();

            System.out.println("All Registered GymOwners");

            while (rs.next()) {
                int gymOwnerId = rs.getInt("gymOwnerId");
                String name = rs.getString("ownerName");
                String phone = rs.getString("ownerPhone");
                String address = rs.getString("ownerAddress");
                String gstNum = rs.getString("ownerGstNum");
                String panNum = rs.getString("ownerPanNum");
                String approvalStatus = rs.getString("approvalStatus");
                int userId = rs.getInt("userId");
                gymOwnerList.add(new FlipFitGymOwner(gymOwnerId, name, phone, address, gstNum, panNum, approvalStatus, userId));
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

        return gymOwnerList;
    }

    @Override
    public List<FlipFitGymOwner> viewGymOwnerDetails(int ownerId) {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<FlipFitGymOwner> gymOwnerList = new ArrayList<FlipFitGymOwner>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/FlipFit", "root", "mysqliswow");

            String query = "SELECT * FROM flipfitGymOwner WHERE ownerId = ?";
            stmt = con.prepareStatement(query);
            stmt.setInt(1, ownerId);

            rs = stmt.executeQuery();

            System.out.println("All Details of GymOwner: " + ownerId);

            if (rs.next()) {
                // Retrieve and display the gym owner details

                int gymOwnerId = rs.getInt("gymOwnerId");
                String name = rs.getString("ownerName");
                String phone = rs.getString("ownerPhone");
                String address = rs.getString("ownerAddress");
                String gstNum = rs.getString("ownerGstNum");
                String panNum = rs.getString("ownerPanNum");
                String approvalStatus = rs.getString("approvalStatus");
                int userId = rs.getInt("userId");

                gymOwnerList.add(new FlipFitGymOwner(gymOwnerId, name, phone, address, gstNum, panNum, approvalStatus, userId));

                return gymOwnerList;
            } else {
                System.out.println("No gym owner found with ID " + ownerId);
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
        return gymOwnerList;
    }

    @Override
    public List<FlipFitGymOwner> viewGymOwnerRequests() {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<FlipFitGymOwner> gymOwnerList = new ArrayList<FlipFitGymOwner>();

        try {

            Class.forName("com.mysql.jdbc.Driver");

            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/FlipFit", "root", "mysqliswow");


            String query = "SELECT * FROM flipfitGymOwner WHERE approvalStatus = 'PENDING'";
            stmt = con.prepareStatement(query);


            rs = stmt.executeQuery();


            boolean hasRequests = false;
            System.out.println("Pending Gym Owner Requests:");

            while (rs.next()) {
                int gymOwnerId = rs.getInt("ownerId");
                String name = rs.getString("ownerName");
                String phone = rs.getString("ownerPhone");
                String address = rs.getString("ownerAddress");
                String gstNum = rs.getString("ownerGstNum");
                String panNum = rs.getString("ownerPanNum");
                String approvalStatus = rs.getString("approvalStatus");
                int userId = rs.getInt("userId");

                gymOwnerList.add(new FlipFitGymOwner(gymOwnerId, name, phone, address, gstNum, panNum, approvalStatus, userId));

//                System.out.println("ID: " + id);
//                System.out.println("Name: " + name);
//                System.out.println("Phone: " + phone);
//                System.out.println("Address: " + address);
//                System.out.println("GST Number: " + gstNum);
//                System.out.println("PAN Number: " + panNum);
//                System.out.println("Approval Status: " + approvalStatus);
//                System.out.println("=================================");
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
        return gymOwnerList;
    }


    @Override
    public boolean approveGymOwnerRequests(int ownerId) {
        Connection con = null;
        PreparedStatement stmt = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/FlipFit", "root", "mysqliswow");


            String query = "UPDATE flipfitGymOwner SET approvalStatus = 'APPROVED' WHERE ownerId = ? AND approvalStatus = 'PENDING'";
            stmt = con.prepareStatement(query);
            stmt.setInt(1, ownerId);

            int rowsAffected = stmt.executeUpdate();


            if (rowsAffected > 0) {
                System.out.println("Gym owner with ID " + ownerId + " has been approved.");
                return true;
            } else {
                System.out.println("No pending request found for gym owner with ID " + ownerId);
                return false;
            }
        } catch (Exception e) {

            System.out.println("Error: " + e.getMessage());
            return false;
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
    public boolean removeGymOwner(int ownerId) {
        Connection con = null;
        PreparedStatement stmt = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/FlipFit", "root", "mysqliswow");


            String query = "DELETE FROM flipfitGymOwner WHERE ownerId = ?";

            stmt = con.prepareStatement(query);
            stmt.setInt(1, ownerId);

            int rowsAffected = stmt.executeUpdate();


            if (rowsAffected > 0) {
                System.out.println("Gym owner with ID " + ownerId + " has been deleted.");
                return true;
            } else {
                System.out.println("No gym owner found with ID " + ownerId);
                return false;
            }
        } catch (Exception e) {

            System.out.println("Error: " + e.getMessage());
            return false;
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
    public boolean cancelRequest(int ownerId) {
        Connection con = null;
        PreparedStatement stmt = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");


            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/FlipFit", "root", "mysqliswow");

            String query = "UPDATE flipfitGymOwner SET approvalStatus = 'CANCELED' WHERE ownerId = ? AND approvalStatus = 'PENDING'";
            stmt = con.prepareStatement(query);
            stmt.setInt(1, ownerId);


            int rowsAffected = stmt.executeUpdate();


            if (rowsAffected > 0) {
                System.out.println("Request for gym owner with ID " + ownerId + " has been canceled.");
                return true;             } else {
                System.out.println("No pending request found for gym owner with ID " + ownerId);
                return false;
            }
        } catch (Exception e) {

            System.out.println("Error: " + e.getMessage());
            return false;
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
