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
		iPlantProfileService = new PlantProfileService();
	}

	/**
	 * todo
	 */
	@GET
	@Path("/plantprofiles/{userID}")
	public Response getMyPlantProfiles(String userId) {
		PlantProfileList plantProfiles = null;
		try {
			plantProfiles = iPlantProfileService.getAllPlantProfiles(userId);
			return Response.status(200).entity(plantProfiles).build();
		} catch (SQLException e) {
			e.printStackTrace();
			return Response.status(500).entity(e).build();
		}
	}

	/**
	 * todo
	 */
	@POST
	@Path("/plantprofiles")
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
	 * todo
	 */
	@PUT
	@Path("/plantprofiles")
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
	 * todo
	 */
	@DELETE
	@Path("/plantprofiles/{plantProfileID}")
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
