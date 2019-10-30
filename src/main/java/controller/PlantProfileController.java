package controller;

import model.PlantProfile;
import model.PlantProfileList;
import service.IPlantProfileService;
import service.PlantProfileService;
import utils.Database;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

@Path("/api")
@Produces("application/json")
@Consumes("application/json")
public class PlantProfileController {
    private IPlantProfileService iPlantProfileService;

    public PlantProfileController() {
        iPlantProfileService = new PlantProfileService(Database.getConnection());
    }

    /**
     * Method triggered by GET request on the endpoint "/order/{id}"
     * This method and endpoint is accessible to customer and contractor
     *
     * Requests a specific order whose plantProfileID was passed in the url parameter
     * and returns it as a JSON in an HTTP Response.
     *
     * @param plantProfileID   plantProfileID of the order to be returned
     * @return order
     */
    @GET
    @Path("/getPlantProfileById/{plantProfileID}")
    public Response getPlantProfileById(@PathParam("plantProfileID") String plantProfileID) {
        PlantProfile plantProfile = null;
        try {
            plantProfile = iPlantProfileService.getPlantProfileById(plantProfileID);
            return Response.status(200).entity(plantProfile).build();

        } catch (SQLException e) {
            e.printStackTrace();
            return Response.status(500).entity(e).build();
        }
    }

    /**
     * Method triggered by GET request on the endpoint "/myorders/{userID}"
     * This method and endpoint is only accessible to customer and contractor
     *
     * Requests a list of all orders assigned to a client whose userID was passed in the url parameter
     * and returns it as a JSON in an HTTP Response.
     *
     * @param userID  userID of the client requesting orders
     * @return orders   list of orders assigned to a client's userID
     */
    @GET
    @Path("/getMyPlantProfiles/{userID}")
    public Response getMyPlantProfiles(@PathParam("userID") String userID) {
        PlantProfileList orders = null;
        try {
            orders = iPlantProfileService.getMyPlantProfiles(userID);
            return Response.status(200).entity(orders).build();

        } catch (SQLException e) {
            e.printStackTrace();
            return Response.status(500).entity(e).build();
        }
    }

    /**
     * Method triggered by POST request on the endpoint "/order"
     * This method and endpoint is only accessible to customer
     *
     * Requests a new order passed in the Request body to be added to the system and returns an HTTP Response.
     *
     * @param plantProfile     order to be added to the system
     */
    @POST
    @Path("/createPlantProfile")
    public Response createPlantProfile(PlantProfile plantProfile) {
        try {
            iPlantProfileService.createPlantProfile(plantProfile);
            return Response.status(200).build();

        } catch (SQLException e) {
            e.printStackTrace();
            return Response.status(500).entity(e).build();
        }
    }

    /**
     * Method triggered by POST request on the endpoint "/order"
     * This method and endpoint is only accessible to customer
     *
     * Requests a new order passed in the Request body to be added to the system and returns an HTTP Response.
     *
     * @param plantProfile     order to be added to the system
     */
    @POST
    @Path("/updatePlantProfile")
    public Response updatePlantProfile(PlantProfile plantProfile) {
        try {
            iPlantProfileService.updatePlantProfile(plantProfile);
            return Response.status(200).build();

        } catch (SQLException e) {
            e.printStackTrace();
            return Response.status(500).entity(e).build();
        }
    }

    /**
     * Method triggered by POST request on the endpoint "/order"
     * This method and endpoint is only accessible to customer
     *
     * Requests a new order passed in the Request body to be added to the system and returns an HTTP Response.
     *
     * @param plantProfileID     order to be added to the system
     */
    @DELETE
    @Path("/deletePlantProfile/{plantProfileID}")
    public Response deletePlantProfile(@PathParam("plantProfileID") String plantProfileID) {
        try {
            iPlantProfileService.deletePlantProfile(plantProfileID);
            return Response.status(200).build();

        } catch (SQLException e) {
            e.printStackTrace();
            return Response.status(500).entity(e).build();
        }
    }
}
