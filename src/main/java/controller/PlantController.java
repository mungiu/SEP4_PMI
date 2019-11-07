package controller;

import model.Plant;
import model.PlantList;
import service.IPlantService;
import service.PlantService;
import utils.Database;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

@Path("/api")
@Produces("application/json")
@Consumes("application/json")
public class PlantController {
    private IPlantService iPlantService;

    public PlantController() { this.iPlantService = new PlantService(Database.getConnection()); }

    /**
     * Method triggered by GET request on the endpoint "/client/{userID}"
     * This method and endpoint is accessible to customer and contractor
     *
     * Requests a specific client object whose userID was passed in the url parameter
     * and returns it as a JSON in an HTTP Response.
     *
     * @param userID   userID of the client to be returned
     * @return order
     */
    @GET
    @Path("/getMyPlants/{userID}")
    public Response getMyPlants(@PathParam("userID") String userID) {
        try {
            PlantList client = iPlantService.getMyPlants(userID);
            return Response.status(200).entity(client).build();
        } catch (SQLException e) {
            e.printStackTrace();
            return Response.status(500).build();
        }
    }

    /**
     * Method triggered by GET request on the endpoint "/client/{plantID}"
     * This method and endpoint is accessible to customer and contractor
     *
     * Requests a specific client object whose plantID was passed in the url parameter
     * and returns it as a JSON in an HTTP Response.
     *
     * @param plantID   plantID of the client to be returned
     * @return order
     */
    @GET
    @Path("/getPlantById/{plantID}")
    public Response getPlantById(@PathParam("plantID") String plantID) {
        try {
            Plant plant = iPlantService.getPlantById(plantID);
            return Response.status(200).entity(plant).build();
        } catch (SQLException e) {
            e.printStackTrace();
            return Response.status(500).build();
        }
    }

    /**
     * Method triggered by POST request on the endpoint "/client"
     * This method and endpoint is accessible to customer and contractor
     *
     * Requests a registration of the new client whose details are passed in the Request body
     * and returns it as a JSON in an HTTP Response.
     *
     * @param client   client to be registered
     * @return order
     */
    @POST
    @Path("/createPlant")
    public Response createPlant(Plant client)
    {
        try {
            iPlantService.createPlant(client);

            return Response.status(200).build();

        } catch (SQLException e) {
            e.printStackTrace();
            return Response.status(500).build();
        }
    }

    /**
     * Method triggered by POST request on the endpoint "/order"
     * This method and endpoint is only accessible to customer
     *
     * Requests a new order passed in the Request body to be added to the system and returns an HTTP Response.
     *
     * @param plant     order to be added to the system
     */
    @POST
    @Path("/updatePlant")
    public Response updatePlant(Plant plant) {
        try {
            iPlantService.updatePlant(plant);
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
     * @param plantID     order to be added to the system
     */
    @POST
    @Path("/deletePlant/{plantID}")
    public Response deletePlant(@PathParam("plantID") String plantID) {
        try {
            iPlantService.deletePlant(plantID);
            return Response.status(200).build();

        } catch (SQLException e) {
            e.printStackTrace();
            return Response.status(500).entity(e).build();
        }
    }
}