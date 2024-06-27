package com.flipkart.dao;

import java.sql.*; 
public class FlipfitAdminDAOImpl implements FlipfitAdminDAOInterface{
	 public static void main(String[] args) {
	        FlipfitAdminDAOInterface dao = new FlipfitAdminDAOImpl();
	        boolean flag=dao.viewGymOwnerRequests();
	        flag=dao.approveGymOwnerRequests(23);
	        dao.viewGymOwnerRequests();
	        dao.cancelRequest(22);
	        dao.cancelRequest(10);
	        
	        
	    }
    @Override
    public void createAdmin(int adminId, String adminEmail, String adminPassword) {};

    @Override
    public boolean viewGymOwnerDetails(int ownerId) {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/flipfit", "root", "mysqliswow");

            String query = "SELECT * FROM flipfitGymOwner WHERE ownerId = ?";
            stmt = con.prepareStatement(query);
            stmt.setInt(1, ownerId);

            rs = stmt.executeQuery();

            if (rs.next()) {
                // Retrieve and display the gym owner details
                String name = rs.getString("ownerName");
                String phone = rs.getString("ownerPhone");
                String address = rs.getString("ownerAddress");
                String gstNum = rs.getString("ownerGstNum");
                String panNum = rs.getString("ownerPanNum");
                String approvalStatus = rs.getString("approvalStatus");

                System.out.println("Gym Owner Details:");
                System.out.println("ID: " + ownerId);
                System.out.println("Name: " + name);
                System.out.println("Phone: " + phone);
                System.out.println("Address: " + address);
                System.out.println("GST Number: " + gstNum);
                System.out.println("PAN Number: " + panNum);
                System.out.println("Approval Status: " + approvalStatus);
                System.out.println("=================================");

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
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (Exception e) {
                System.out.println("Error closing resources: " + e.getMessage());
            }
        }
    }

    @Override
    public boolean viewGymOwnerRequests() {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
        
            Class.forName("com.mysql.jdbc.Driver");

            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/flipfit", "root", "mysqliswow");

            
            String query = "SELECT * FROM flipfitGymOwner WHERE approvalStatus = 'PENDING'";
            stmt = con.prepareStatement(query);

            
            rs = stmt.executeQuery();

        
            boolean hasRequests = false;
            System.out.println("Pending Gym Owner Requests:");

            while (rs.next()) {
                int id = rs.getInt("ownerId");
                String name = rs.getString("ownerName");
                String phone = rs.getString("ownerPhone");
                String address = rs.getString("ownerAddress");
                String gstNum = rs.getString("ownerGstNum");
                String panNum = rs.getString("ownerPanNum");
                String approvalStatus = rs.getString("approvalStatus");

                System.out.println("ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Phone: " + phone);
                System.out.println("Address: " + address);
                System.out.println("GST Number: " + gstNum);
                System.out.println("PAN Number: " + panNum);
                System.out.println("Approval Status: " + approvalStatus);
                System.out.println("=================================");

                hasRequests = true;
            }

                        return hasRequests;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return false; 
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
    public boolean approveGymOwnerRequests(int ownerId) {
        Connection con = null;
        PreparedStatement stmt = null;

        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/flipfit_schema", "root", "Fk!@#%215038");

      
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
    	
        return false;
    }

    @Override
    public boolean cancelRequest(int ownerId) {
        Connection con = null;
        PreparedStatement stmt = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

        
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/flipfit_schema", "root", "Fk!@#%215038");

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
