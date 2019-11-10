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
     * todo
     */
    @GET
    @Path("/plants")
    public Response getPlants() {
        try {
            PlantList plants = iPlantService.getAllPlants();
            return Response.status(200).entity(plants).build();
        } catch (SQLException e) {
            e.printStackTrace();
            return Response.status(500).build();
        }
    }

    /**
     * todo
     */
    @GET
    @Path("/plants/{plantID}")
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
     * todo
     */
    @POST
    @Path("/plants")
    public Response createPlant(Plant plant)
    {
        try {
            iPlantService.createPlant(plant);
            return Response.status(200).build();
        } catch (SQLException e) {
            e.printStackTrace();
            return Response.status(500).build();
        }
    }

    /**
     * todo
     */
    @PUT
    @Path("/plants")
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
     * todo
     */
    @POST
    @Path("/plants/{plantID}")
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