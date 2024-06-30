package com.flipkart.restcontroller;

import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.flipkart.bean.Booking;
import com.flipkart.bean.FlipFitGym;
import com.flipkart.bean.FlipFitGymOwner;
import com.flipkart.business.*;
import com.flipkart.exceptions.UserNotFoundException;
import com.flipkart.exceptions.WrongCredentialsException;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.List;


@Path("/owner")
@Produces(MediaType.APPLICATION_JSON)
public class GymFlipFitOwnerController {
    FlipFitGymOwnerInterface gymOwnerService = new FlipFitGymOwnerService();
    FlipFitUserInterface userService = new FlipFitUserService();
    int userId =-1;

    // http://localhost:8080/owner/create?name=Joey%20Doe&email=joeydoe@example.com&password=securePassword&phone=1234567890&address=123%20Main%20St&pan_no=ABCDE1234F&gst_no=12ABCDE1234F1Z5
    @GET
    @Path("/create")
    public Response createGymOwner(@QueryParam("name") String name, @QueryParam("name") String email, @QueryParam("name") String password, @QueryParam("phone") String phone, @QueryParam("address") String address, @QueryParam("pan_no") String panNo, @QueryParam("gst_no") String gstNo) {

        userId = userService.createUser(email, password, 2);
        gymOwnerService.createGymOwner(userId, name, phone, address, panNo, gstNo);
        return Response.ok("Gym owner created successfully").build();
    }

    // http://localhost:8080/owner/login?email=gymowner@example.com&password=password123
    @GET
    @Path("/login")
    public Response login(@QueryParam("email") String email, @QueryParam("password") String password) {
        userId = userService.authenticateUser(email, password, 2);
        if (userId > 0) {
            return Response.ok("Logged in as Gym Owner").build();
        } else {
            return Response.status(Response.Status.UNAUTHORIZED).entity("Invalid Email or Password").build();
        }
    }

    // http://localhost:8080/owner/registerGym?name=Fit%20Gym&location=Central%20Park
    @GET
    @Path("/registerGym")
    public Response registerGym(@QueryParam("name") String name, @QueryParam("location") String location) {
        if (userId <= 0)
            return Response.status(Response.Status.UNAUTHORIZED).entity("You are not an authorized user!").build();
        gymOwnerService.registerGym(userId, name, location);
        return Response.ok("Gym registered successfully").build();
    }

    // http://localhost:8080/owner/editGym?gymId=1&name=Fitness%20Center&location=Downtown
    @GET
    @Path("/editGym")
    public Response editGym(@QueryParam("gymId") int gymId, @QueryParam("name") String name, @QueryParam("location") String location) {
        if (userId <= 0)
            return Response.status(Response.Status.UNAUTHORIZED).entity("You are not an authorized user!").build();
        gymOwnerService.editGym(gymId, name, location);
        return Response.ok("Gym details updated").build();
    }

    // http://localhost:8080/owner/removeGym?gymId=1
    @GET
    @Path("/removeGym")
    public Response removeGym(@QueryParam("gymId") int gymId) {
        if (userId <= 0)
            return Response.status(Response.Status.UNAUTHORIZED).entity("You are not an authorized user!").build();
        gymOwnerService.removeGym(gymId);
        return Response.ok("Gym removed successfully").build();
    }

    // http://localhost:8080/owner/addSlot?gymId=1&slotId=11&slotTime=10-11&slotCapacity=20&slotPrice=200
    @GET
    @Path("/addSlot")
    public Response addSlot(@QueryParam("gymId") int gymId, @QueryParam("slotId") int slotId,
                            @QueryParam("slotTime") String slotTime, @QueryParam("slotCapacity") int slotCapacity, @QueryParam("slotPrice") int slotPrice) {
        if (userId <= 0)
            return Response.status(Response.Status.UNAUTHORIZED).entity("You are not an authorized user!").build();
        gymOwnerService.addSlot(gymId, slotId, slotTime, slotCapacity, slotPrice);
        return Response.ok("Slot added successfully").build();
    }

    // http://localhost:8080/owner/removeSlot?gymId=1&slotId=1
    @GET
    @Path("/removeSlot")
    public Response removeSlot(@QueryParam("gymId") int gymId, @QueryParam("slotId") int slotId) {
        if (userId <= 0)
            return Response.status(Response.Status.UNAUTHORIZED).entity("You are not an authorized user!").build();
        gymOwnerService.removeSlot(gymId, slotId);
        return Response.ok("Slot removed successfully").build();
    }

    // http://localhost:8080/owner/viewAvailableSlots?gymId=1&date=01/07/2024
    @GET
    @Path("/viewAvailableSlots")
    public Response viewAvailableSlots(@QueryParam("gymId") int gymId, @QueryParam("date") String date) {
        if (userId <= 0)
            return Response.status(Response.Status.UNAUTHORIZED).entity("You are not an authorized user!").build();
        HashMap<String, Integer> availableSlots = gymOwnerService.viewAvailableSlots(gymId, date);
        ObjectMapper mapper = new ObjectMapper();
        String json = null;
        try {
            json = mapper.writeValueAsString(availableSlots);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return Response.ok("All available slots are listed below:\n" + json).build();
    }

    // http://localhost:8080/owner/viewAllBookings
    @GET
    @Path("/viewAllBookings")
    public Response viewAllBookings() {
        if (userId <= 0)
            return Response.status(Response.Status.UNAUTHORIZED).entity("You are not an authorized user!").build();
        List<Booking> bookings = gymOwnerService.viewAllBookings(userId);
        ObjectMapper mapper = new ObjectMapper();
        String json = null;
        try {
            json = mapper.writeValueAsString(bookings);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return Response.ok("All bookings of your gyms are listed below:\n" + json).build();
    }

    // http://localhost:8080/owner/viewBookings?gymId=1
    @GET
    @Path("/viewBookings")
    public Response viewBookings(@QueryParam("gymId") int gymId) {
        if (userId <= 0)
            return Response.status(Response.Status.UNAUTHORIZED).entity("You are not an authorized user!").build();
        List<Booking> bookings = gymOwnerService.viewBookings(gymId);

        ObjectMapper mapper = new ObjectMapper();
        String json = null;
        try {
            json = mapper.writeValueAsString(bookings);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return Response.ok("All bookings of gym "+ gymId +" are listed below:\n" + json).build();
    }

    // http://localhost:8080/owner/viewAllGyms
    @GET
    @Path("/viewAllGyms")
    public Response viewAllGyms() {
        if (userId <= 0)
            return Response.status(Response.Status.UNAUTHORIZED).entity("You are not an authorized user!").build();
        List<FlipFitGym> gyms = gymOwnerService.viewAllRegisteredGymCenters(userId);
        ObjectMapper mapper = new ObjectMapper();
        String json = null;
        try {
            json = mapper.writeValueAsString(gyms);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return Response.ok("All your gyms are listed below:\n" + json).build();
    }

    // http://localhost:8080/owner/editProfile?name=John%20Doe&phoneNumber=1234567890&address=123%20Main%20St&panNum=ABCDE1234F&gstNum=12ABCDE1234F1Z5
    @GET
    @Path("/editProfile")
    public Response editProfile(@QueryParam("name") String name,
                                @QueryParam("phoneNumber") String phoneNumber, @QueryParam("address") String address,
                                @QueryParam("panNum") String panNum, @QueryParam("gstNum") String gstNum) {
        try {
            if (userId <= 0)
                return Response.status(Response.Status.UNAUTHORIZED).entity("You are not an authorized user!").build();
            gymOwnerService.editProfile(userId, name, phoneNumber, address, panNum, gstNum);
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
        return Response.ok("Successfully Edited the Profile").build();
    }

    // http://localhost:8080/owner/logout
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


