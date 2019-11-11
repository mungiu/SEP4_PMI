package controller;

import service.IUserService;
import service.UserService;

import javax.ws.rs.*;

@Path("/api")
@Produces("application/json")
@Consumes("application/json")
public class UserController {
    private IUserService iUserService;

    public UserController() { iUserService = new UserService(); }

}
