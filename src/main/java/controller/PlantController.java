package controller;

import model.WeeklyPlant;
import model.domain.IPlant;
import model.domain.Plant;
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
	public Response getPlantByIdWIthWeekAvg(@PathParam("plantID") int plantID) {
		try {
			WeeklyPlant weeklyPlant = iPlantService.getPlantById(plantID);
			return Response.status(200).entity(weeklyPlant).build();
		} catch (SQLException e) {
			e.printStackTrace();
			return Response.status(500).entity(e.getMessage()).build();
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
			return Response.status(500).entity(e.getMessage()).build();
		}catch (MissingDataException e){
			e.printStackTrace();
			return Response.status(500).entity(e.getMessage()).build();
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
		} catch (MissingDataException e) {
			e.printStackTrace();
			return Response.status(500).entity(e.getMessage()).build();
		} catch (SQLException e){
			e.printStackTrace();
			return Response.status(500).entity(e.getMessage()).build();
		}
	}

	/**
	 * Documentation to be done
	 */
	@DELETE
	@Path("/plants/{plantID}")
	public Response deletePlant(@PathParam("plantID") int plantID) {
		try {
			iPlantService.deletePlant(plantID);
			return Response.status(200).build();
		} catch (SQLException e) {
			e.printStackTrace();
			return Response.status(500).entity(e.getMessage()).build();
		}
	}
}