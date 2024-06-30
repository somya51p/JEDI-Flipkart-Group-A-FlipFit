package com.flipkart.restcontroller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flipkart.bean.Booking;
import com.flipkart.bean.FlipFitGym;
import com.flipkart.business.*;
import com.flipkart.exceptions.BookingFailedException;
import com.flipkart.exceptions.GymNotFoundException;
import com.flipkart.exceptions.UserNotFoundException;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.List;


@Path("/customer")
@Produces(MediaType.APPLICATION_JSON)
public class GymFlipFitCustomerController {
    FlipFitCustomerInterface customerService = new FlipFitCustomerService();
    BookingGymInterface booking = new BookingGymService();

    int userId = -1;
    
    //http://localhost:8080/customer/register?userEmail=customer@example.com&userPassword=password123&userName=xyz&userPhoneNo=12345&userAddress=xyz
    @GET
    @Path("/register")
    public Response createCustomer(@QueryParam("userEmail") String userEmail, @QueryParam("userPassword") String userPassword, @QueryParam("userName") String userName,@QueryParam("userPhoneNo") String userPhoneNo,@QueryParam("userAddress") String userAddress ) {
        try {
        	 FlipFitCustomerInterface customerService = new FlipFitCustomerService();
             FlipFitUserInterface userService = new FlipFitUserService();
        	 int newUserId=userService.createUser(userEmail, userPassword, 1);
           	 customerService.createCustomer(newUserId, userName, userPhoneNo, userAddress);
             return Response.ok("Registered successfully as a customer").build();
           
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }
    
    // http://localhost:8080/customer/login?email=customer@example.com&password=password123
    @GET
    @Path("/login")
    public Response customerLogin(@QueryParam("email") String email, @QueryParam("password") String password) {
        FlipFitUserInterface user = new FlipFitUserService();
        userId = user.authenticateUser(email, password, 1);
        if (userId > 0) {
            System.out.println("Logged in as Customer");
            return Response.ok("Successfully Logged In as a Customer").build();
        } else {
            return Response.status(Response.Status.UNAUTHORIZED).entity("Invalid Email or Password").build();
        }
    }

    //http://localhost:8080/customer/edit-profile?name=tgtdrsdrsyz&phoneNumber=4992302&address=dsqtgf
    @GET
    @Path("/edit-profile")
    public Response editProfile(@QueryParam("name") String name, @QueryParam("phoneNumber") String phoneNumber, @QueryParam("address") String address) {
        try {
            customerService.editProfile(userId, name, phoneNumber, address);
        } catch (UserNotFoundException e) {
            return Response.status(Response.Status.UNAUTHORIZED).entity(e.getMessage()).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
        return Response.ok("Successfully Editted the Profile").build();
    }

    //http://localhost:8080/customer/view-gyms
    @GET
    @Path("/view-gyms")
    public Response viewGyms() {
        List<FlipFitGym> gyms = customerService.viewGyms();
        try {
            if (userId <= 0)
                return Response.status(Response.Status.UNAUTHORIZED).entity("You are not an authorized user!").build();
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(gyms);
            return Response.ok("All gyms are listed below:\n" + json).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error converting gym list to JSON").build();
        }
    }

    //http://localhost:8080/customer/view-slots?gymId=1&date=20-07-2024
    @GET
    @Path("/view-slots")
    public Response viewSlots(@QueryParam("gymId") int gymId, @QueryParam("date") String date) {
        try {
            if (userId <= 0)
                return Response.status(Response.Status.UNAUTHORIZED).entity("You are not an authorized user!").build();
            HashMap<String, Integer> slots = customerService.viewSlots(gymId, date);
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(slots);
            return Response.ok("All slots of gymId: " + gymId + " on date: " + date + " are listed below:\n" + json).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    //http://localhost:8080/customer/create-booking?gymId=1&bookingDate=01-07-2024&bookingTime=07:00
    @GET
    @Path("/create-booking")
    public Response createBooking(@QueryParam("gymId") int gymId, @QueryParam("bookingDate") String bookingDate, @QueryParam("bookingTime") String bookingTime) {
        try {
            if (userId <= 0)
                return Response.status(Response.Status.UNAUTHORIZED).entity("You are not an authorized user!").build();
            int transactionId = booking.makePayment(userId, "Rs. 1000 paid Successfully", "10-05-2030", "Net-Banking");
            booking.createBooking(userId, gymId, transactionId, bookingDate, bookingTime, "Confirmed", 1000);
            return Response.ok("Successfully created booking").build();
        } catch (BookingFailedException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    //http://localhost:8080/customer/view-bookings
    @GET
    @Path("/view-bookings")
    public Response viewBookings() {
        try {
            if (userId <= 0)
                return Response.status(Response.Status.UNAUTHORIZED).entity("You are not an authorized user!").build();
            List<Booking> bookingList = booking.viewBookings(userId);
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(bookingList);
            return Response.ok("All bookings are listed below:\n" + json).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    //http://localhost:8080/customer/cancel-booking?bookingId=1
    @GET
    @Path("/cancel-booking")
    public Response cancelBooking(@QueryParam("bookingId") int bookingId) {
        try {
            if (userId <= 0) {
                return Response.status(Response.Status.UNAUTHORIZED).entity("You are not an authorized user!").build();
            }
            booking.cancelBookings(bookingId);
            return Response.ok("Booking cancelled").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }
    
    @GET
    @Path("/logout")
    public Response customerLogOut() {
    	 if (userId <= 0) {
             return Response.status(Response.Status.UNAUTHORIZED).entity("You are not an authorized user!").build();
         }
          userId=-1;
          return Response.ok("Logged out successfully").build();
        
    }
}