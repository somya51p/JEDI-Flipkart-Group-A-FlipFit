package com.flipkart.restcontroller;

import com.codahale.metrics.annotation.Timed;
import com.flipkart.bean.FlipFitGymOwner;
import com.flipkart.business.FlipFitUserInterface;
import com.flipkart.business.FlipFitUserService;
import com.flipkart.business.FlipfitAdminInterface;
import com.flipkart.business.FlipfitAdminService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/admin")
@Produces(MediaType.APPLICATION_JSON)
public class GymFlipFitAdminController {

    FlipFitUserInterface userService = new FlipFitUserService();
    FlipfitAdminInterface adminService = new FlipfitAdminService();
    int userId = -1;

    @GET
    @Path("/login")
    public Response customerLogin(@QueryParam("email") String email, @QueryParam("password") String password) {
        // http://localhost:8080/admin/login?email=admin@example.com&password=password123
        userId = userService.authenticateUser(email, password, 3);
        System.out.println("USER ID: " + userId);
        if (userId > 0) {
            System.out.println("Logged in as Admin");
            return Response.ok("Successfully Logged In as Admin").build();
        } else {
            return Response.status(Response.Status.UNAUTHORIZED).entity("Invalid Email or Password").build();
        }
    }

    @GET
    @Path("/view-gym-owners")
    @Timed
    public Response getViewAllGymOwners() {
        // http://localhost:8080/admin/view-gym-owners
        try{
            List<FlipFitGymOwner> gymOwnerList = adminService.viewAllGymOwners();
            return Response.ok(gymOwnerList).build();
        } catch (Exception e){
            return Response.status(Response.Status.UNAUTHORIZED).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/view-gym-owner-details")
    @Timed
    public Response viewGymOwnerDetails(@QueryParam("ownerId") int ownerId) {
        // http://localhost:8080/admin/view-gym-owner-details?ownerId=1
        try {
            List<FlipFitGymOwner> gymOwnerList = adminService.viewGymOwnerDetails(ownerId);
            return Response.ok(gymOwnerList).build();
        } catch (Exception e){
            return Response.status(400).entity("Invalid Gym Owner details").build();
        }
    }

    @GET
    @Path("/view-gym-owner-requests")
    @Timed
    public Response viewGymOwnerRequests() {
        // http://localhost:8080/admin/view-gym-owner-requests
        try {
            List<FlipFitGymOwner> gymOwnerList = adminService.viewGymOwnerRequests();
            return Response.ok(gymOwnerList).build();
        } catch (Exception e) {
            return Response.status(400).entity("Invalid Gym Owner Requests").build();
        }
    }

    @GET
    @Path("/approve-gym-owner-requests")
    @Timed
    public Response approveGymOwnerRequests(@QueryParam("ownerId") int ownerId) {
        // http://localhost:8080/admin/approve-gym-owner-requests?ownerId=1
        try {
            adminService.approveGymOwnerRequests(ownerId);
            return Response.ok("Approved the gym owner requests with Id").build();
        } catch (Exception e) {
            return Response.status(400).entity("Invalid Gym Owner Requests").build();
        }
    }

    @GET
    @Path("/remove-gym-owner")
    @Timed
    public Response removeGymOwner(@QueryParam("ownerId") int ownerId) {
        // http://localhost:8080/admin/remove-gym-owner?ownerId=1
        try {
            adminService.removeGymOwner(ownerId);
            return Response.ok("Removed the gym owner with Id").build();
        } catch (Exception e) {
            return Response.status(400).entity("Invalid Gym Owner").build();
        }
    }

    @GET
    @Path("/cancel-request")
    @Timed
    public Response cancelRequest(@QueryParam("ownerId") int ownerId) {
        // http://localhost:8080/admin/cancel-request?ownerId=1
        try {
            adminService.cancelRequest(ownerId);
            return Response.ok("Request cancelled").build();
        } catch (Exception e) {
            return Response.status(400).entity("Invalid Gym Owner").build();
        }
    }
}
