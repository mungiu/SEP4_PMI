package service;

import dao.PlantDao;
import dao.PlantProfileDao;
import dao.UserDao;
import model.IUser;
import model.PlantList;
import model.PlantProfileList;
import model.User;

import java.sql.SQLException;
import java.text.ParseException;

public class UserService implements IUserService {
    // TODO: What's that? This shouldn't be here.
    public PlantDao plantDao;
    public PlantProfileDao plantProfileDao;
    public UserDao userDao;

    public UserService() {
        plantDao = new PlantDao();
        plantProfileDao = new PlantProfileDao();
        userDao = new UserDao();
    }

    // TODO: What's that? This shouldn't be here.
    public void instanciateDaoIfNull(){
        if(plantProfileDao == null){
            plantProfileDao = new PlantProfileDao();
        }
        if(plantDao == null){
            plantDao = new PlantDao();
        }
        if(userDao == null){
            userDao = new UserDao();
        }
    }

    /**
     * Queries a database and returns a specific address
     *
     * @param userID of the address to be returned
     * @return address
     */
    public IUser getUserById(String userID) throws SQLException, ParseException {
        instanciateDaoIfNull();
        PlantProfileList profileList = plantProfileDao.getPlantProfiles(userID);
        PlantList plantList = plantDao.getPlants(userID);
        IUser user = new User(userID, profileList, plantList);
        return user;
    }

    @Override
    public void deleteUser(String userID) throws SQLException {
        // TODO
    }

    @Override
    public void updateUser(IUser user) throws SQLException {
        // TODO
    }

    @Override
    public void createUser(IUser plant) throws SQLException {
        // TODO
    }
}
