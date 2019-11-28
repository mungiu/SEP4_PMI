package controller;

import model.IPlant;
import model.Plant;
import service.IPlantService;
import service.PlantService;
import utils.exceptions.MissingDataException;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

@Path("/api")
@Produces("application/json")
@Consumes("application/json")
public class PlantController {
	private IPlantService iPlantService;

	public PlantController() {
		this.iPlantService = new PlantService();
	}

	@GET
	@Path("/test")
	public Response test(){
		return Response.status(200).entity("Hello").build();
	}

	/**
	 * Documentation to be done
	 */
	@GET
	@Path("/plants/{plantID}")
	public Response getPlantById(@PathParam("plantID") String plantID) {
		try {
			IPlant plant = iPlantService.getPlantById(plantID);
			return Response.status(200).entity(plant).build();
		} catch (SQLException e) {
			e.printStackTrace();
			return Response.status(500).build();
		}
	}

	/**
	 * Documentation to be done
	 */
	@POST
	@Path("/plants")
	public Response createPlant(Plant plant) {
		try {
			iPlantService.createPlant(plant);
			return Response.status(200).build();
		} catch (SQLException e) {
			e.printStackTrace();
			return Response.status(500).build();
		} catch (MissingDataException e) {
			return Response.status(500).entity(e).build();
		}
	}

	/**
	 * Documentation to be done
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
		} catch (MissingDataException e) {
			return Response.status(500).entity(e).build();
		}
	}

	/**
	 * Documentation to be done
	 */
	@DELETE
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