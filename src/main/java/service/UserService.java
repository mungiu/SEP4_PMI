package service;

import dao.PlantDao;
import dao.PlantProfileDao;
import dao.UserDao;
import model.Plant;
import model.User;
import utils.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

public class UserService implements IUserService {
    public PlantDao plantDao;
    public PlantProfileDao plantProfileDao;
    public UserDao userDao;

    public UserService() {
        plantDao = new PlantDao();
        plantProfileDao = new PlantProfileDao();
        userDao = new UserDao();
    }

    /**
     * Queries a database and returns a specific address
     *
     * @param userID of the address to be returned
     * @return address
     */
    public User getUserById(String userID) throws SQLException {
return null;
    }

    @Override
    public void deleteUser(String userID) throws SQLException {
        // TODO
    }

    @Override
    public void updateUser(User user) throws SQLException {
        // TODO
    }

    @Override
    public void createUser(User plant) throws SQLException {
        // TODO
    }
}
