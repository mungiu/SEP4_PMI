package controller;

import model.PlantProfile;
import model.PlantProfileList;
import model.User;
import service.IUserService;
import service.UserService;
import utils.Database;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

@Path("/api")
@Produces("application/json")
@Consumes("application/json")
public class UserController {
    private IUserService iUserService;

    public UserController() {
        iUserService = new UserService();
    }

    /**
     * Method triggered by GET request on the endpoint "/order/{id}"
     * This method and endpoint is accessible to customer and contractor
     *
     * Requests a specific order whose userID was passed in the url parameter
     * and returns it as a JSON in an HTTP Response.
     *
     * @param userID   userID of the order to be returned
     * @return order
     */
    @GET
    @Path("/order/{id}")
    public Response getUserById(@PathParam("id") int userID) {
        User plantProfile = null;
        try {
            plantProfile = iUserService.getUserById(userID);
            return Response.status(200).entity(plantProfile).build();

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
     * @param user     order to be added to the system
     */
    @POST
    @Path("/order")
    public Response createUser(User user) {
        try {
            iUserService.createUser(user);
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
     * @param user     order to be added to the system
     */
    @POST
    @Path("/order")
    public Response updateUser(User user) {
        try {
            iUserService.updateUser(user);
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
     * @param userID     order to be added to the system
     */
    @POST
    @Path("/order")
    public Response deleteUser(String userID) {
        try {
            iUserService.deleteUser(userID);
            return Response.status(200).build();

        } catch (SQLException e) {
            e.printStackTrace();
            return Response.status(500).entity(e).build();
        }
    }
}
