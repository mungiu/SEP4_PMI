package controller;

import model.domain.IUser;
import service.IUserService;
import service.UserService;
import utils.exceptions.InvalidPasswordException;
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
        } catch (SQLException | ParseException e) {
            e.printStackTrace();
            return Response.status(500).build();
        }
    }

    @POST
    @Path("/login")
    public Response login(IUser user){
        try{
            boolean loginSucceed = iUserService.login(user);
            return Response.status(200).entity(loginSucceed).build();
        }catch (SQLException | InvalidPasswordException | UserNotFoundException e){
            e.printStackTrace();
            return Response.status(500).entity(e).build();
        }
    }
}
