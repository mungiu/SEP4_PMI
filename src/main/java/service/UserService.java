package service;

import dao.PlantDao;
import dao.PlantProfileDao;
import dao.UserDao;
import model.domain.IUser;
import model.PlantList;
import model.PlantProfileList;
import model.domain.User;
import utils.exceptions.InvalidPasswordException;
import utils.exceptions.UserNotFoundException;

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

    /**
     * Queries a database and returns a specific address
     *
     * @param userID of the address to be returned
     * @return address
     */
    public IUser getUserById(String userID) throws SQLException, ParseException {
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

    @Override
    public boolean login(IUser user) throws InvalidPasswordException, UserNotFoundException, SQLException {
            if(userDao.userExists(user.getEmail())){
                if(userDao.validLogin(user)){
                    return true;
                }
                else {
                    throw new InvalidPasswordException();
                }
            }else {
                throw new UserNotFoundException();
            }
       }
}
