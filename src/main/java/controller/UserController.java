package controller;

import model.domain.IUser;
import model.domain.Plant;
import model.domain.User;
import service.IUserService;
import service.UserService;
import utils.exceptions.InvalidPasswordException;
import utils.exceptions.MissingDataException;
import utils.exceptions.UserAlreadyExists;
import utils.exceptions.UserNotFoundException;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.text.ParseException;

@Path("/api")
@Produces("application/json")
@Consumes("application/json")
public class UserController {
    private IUserService iUserService;

    public UserController() {
        iUserService = new UserService();
    }

    /**
     * Documentation to be done
     */
    @GET
    @Path("/users/{userID}")
    public Response getUserById(@PathParam("userID") String userId) {
        try {
            IUser user = iUserService.getUserById(userId);
            return Response.status(200).entity(user).build();
        } catch (SQLException | ParseException | UserNotFoundException e) {
            e.printStackTrace();
            return Response.status(500).entity(e.getMessage()).build();
        }
    }

    @POST
    @Path("/login")
    public Response login(User user){
        try{
            boolean loginSucceed = iUserService.login(user);
            return Response.status(200).entity(loginSucceed).build();
        }catch (SQLException | InvalidPasswordException | UserNotFoundException e){
            e.printStackTrace();
            return Response.status(500).entity(e).build();
        }
    }

    @POST
    @Path("/users")
    public Response createUser(User user){
        try{
            boolean signUpSucceed = iUserService.createUser(user);
            return Response.status(200).entity(signUpSucceed).build();


        } catch (SQLException | UserAlreadyExists e) {
            e.printStackTrace();
            return Response.status(500).entity(e).build();
        }
    }
    @DELETE
    @Path("/users/{email}")
    public Response deleteUser(@PathParam("email") String email){
        try{
            iUserService.deleteUser(email);
            return Response.status(200).build();

        } catch (SQLException e) {
            e.printStackTrace();
            return Response.status(500).entity(e).build();
        }
    }
    @PUT
    @Path("/users/{email}")
    public Response updateUser(@PathParam("email") String email, User user) {
        try {
            iUserService.updateUser(email, user);
            return Response.status(200).build();
        } catch (SQLException e){
            e.printStackTrace();
            return Response.status(500).entity(e.getMessage()).build();
        }
    }
}
