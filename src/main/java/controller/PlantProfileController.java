package controller;

import model.domain.PlantProfile;
import service.IPlantProfileService;
import service.PlantProfileService;
import utils.exceptions.MissingDataException;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

@Path("/api")
@Produces("application/json")
@Consumes("application/json")
public class PlantProfileController {
	private IPlantProfileService iPlantProfileService;

	public PlantProfileController() {
		iPlantProfileService = new PlantProfileService();
	}

	/**
	 * Documentation to be done
	 */
	@GET
	@Path("/plantprofiles/{plantProfileID}")
	public Response getPlantProfileById(@PathParam("plantProfileID") int profileId) {
		try {
			PlantProfile plant = iPlantProfileService.getPlantProfileById(profileId);
			// TODO: Uncomment the bellow method when we're able to receive a plant profile from the database
			// return Response.status(200).entity(plant).build();
			return Response.status(200).entity("Response from the getPlantProfileById method").build();
		} catch (SQLException e) {
			e.printStackTrace();
			return Response.status(500).build();
		}
	}

	/**
	 * Documentation to be done
	 */
	@POST
	@Path("/plantprofiles")
	public Response createPlantProfile(PlantProfile plantProfile) {
		try {
			iPlantProfileService.createPlantProfile(plantProfile);
			return Response.status(200).build();
		} catch (SQLException | MissingDataException e) {
			e.printStackTrace();
			return Response.status(500).entity(e.getMessage()).build();
		}
	}

	/**
	 * Documentation to be done
	 */
	@PUT
	@Path("/plantprofiles")
	public Response updatePlantProfile(PlantProfile plantProfile) {
		try {
			iPlantProfileService.updatePlantProfile(plantProfile);
			return Response.status(200).build();
		} catch (SQLException | MissingDataException e) {
			e.printStackTrace();
			return Response.status(500).entity(e.getMessage()).build();
		}
	}

	/**
	 * Documentation to be done
	 */
	@DELETE
	@Path("/plantprofiles/{plantProfileID}")
	public Response deletePlantProfile(@PathParam("plantProfileID") int plantProfileID) {
		try {
			iPlantProfileService.deletePlantProfile(plantProfileID);
			return Response.status(200).build();
		} catch (SQLException e) {
			e.printStackTrace();
			return Response.status(500).entity(e).build();
		}
	}
}
