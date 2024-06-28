package com.flipkart.dao;

public class BookingGymDAOImpl implements BookingGymDAOInterface {
<<<<<<< Updated upstream
    @Override
    public void createBooking(int bookingId, int customerId, int gymId, int transactionId, String bookingDate, String bookingTimeSlot, String bookingType, int bookingAmount) {

=======

    public static void main(String[] args) {
        BookingGymDAOInterface dao = new BookingGymDAOImpl();
//        dao.createBooking(1, 1, 150, 250, "02-03-24","5", "confirmed", 500);
//        dao.makePayment(2, 1111333333, "12/25", "net banking");
        dao.cancelBookings(2);
    }

    @Override
    public void createBooking(int userId, int gymId, int transactionId, String bookingDate, String bookingTimeSlot, String bookingType, int bookingAmount) {
        Connection con = null;
        PreparedStatement stmt = null;
        PreparedStatement stmtcustomer = null;
        ResultSet rs1 = null;
        int customerId = 0;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(

                    "jdbc:mysql://localhost:3306/FlipFit", "root", "mysqliswow");

            String queryOwner = "SELECT customerId FROM flipfitCustomer WHERE userId = ?";
            stmtcustomer = con.prepareStatement(queryOwner);
            stmtcustomer.setInt(1, userId);

            rs1 = stmtcustomer.executeQuery();

            while (rs1.next()) {
                customerId = rs1.getInt("customerId");
            }

            String query = "INSERT INTO booking (customerId, gymId, transactionId, bookingDate, bookingTimeSlot, bookingType, bookingAmount) VALUES (?, ?, ?, ?, ?, ?, ?)";
            stmt = con.prepareStatement(query);

            stmt.setInt(1, customerId);
            stmt.setInt(2, gymId);
            stmt.setInt(3, transactionId);
            stmt.setString(4, bookingDate);
            stmt.setString(5, bookingTimeSlot);
            stmt.setString(6, bookingType);
            stmt.setInt(7, bookingAmount);

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Booking created successfully");
            } else {
                System.out.println("Failed to create booking");
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
>>>>>>> Stashed changes
    }

    @Override
    public void bookSlots() {

    }

    @Override
    public void viewBookings() {

    }

    @Override
    public void cancelBookings() {

    }

    @Override
<<<<<<< Updated upstream
    public void makePayment() {

=======
    public int makePayment(int userId, String paymentDetails, String expiryDate, String modeOfPayment) {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int transactionId = 0;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/FlipFit", "root", "mysqliswow");

            String query = "INSERT INTO Payment (paymentDetails, expiryDate, modeOfPayment) VALUES (?, ?, ?)";
            stmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1, paymentDetails);
            stmt.setString(2, expiryDate);
            stmt.setString(3, modeOfPayment);

            int result = stmt.executeUpdate();
            if (result > 0) {
                // Retrieve the auto-generated transactionId
                rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                    transactionId = rs.getInt(1);
                    System.out.println("Generated transactionId: " + transactionId);
                }
                System.out.println("Payment successfully recorded.");
            } else {
                System.out.println("Failed to record payment.");
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
        return transactionId;
>>>>>>> Stashed changes
    }
    //data interaction not data manipulation --> client -> service -> DAO
}
