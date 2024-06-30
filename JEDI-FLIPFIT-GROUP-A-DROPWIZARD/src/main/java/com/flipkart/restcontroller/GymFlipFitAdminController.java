package com.flipkart.restcontroller;

import com.codahale.metrics.annotation.Timed;
import com.flipkart.bean.FlipFitGymOwner;
import com.flipkart.business.FlipfitAdminInterface;
import com.flipkart.business.FlipfitAdminService;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/flipFlipAdminApi")
@Produces(MediaType.APPLICATION_JSON)
public class GymFlipFitAdminController {

    private static final FlipfitAdminInterface adminService = new FlipfitAdminService();

    @GET
    @Path("/viewAllGymOwners")
    @Timed
    public Response getViewAllGymOwners() {
        // http://localhost:8080/flipFlipAdminApi/viewAllGymOwners
        try{
            List<FlipFitGymOwner> gymOwnerList = adminService.viewAllGymOwners();
            return Response.ok(gymOwnerList).build();
        } catch (Exception e){
            return Response.status(Response.Status.UNAUTHORIZED).entity(e.getMessage()).build();
        }
    }

    @POST
    @Path("/viewGymOwnerDetails")
    @Timed
    public Response viewGymOwnerDetails(FlipFitGymOwner gymOwner) {
        try{
            List<FlipFitGymOwner> gymOwnerList = adminService.viewGymOwnerDetails(gymOwner.getOwnerId());
            return Response.ok(gymOwnerList).build();
        } catch (Exception e){
            return Response.status(400).entity("Invalid Gym Owner details").build();
        }
    }
}
