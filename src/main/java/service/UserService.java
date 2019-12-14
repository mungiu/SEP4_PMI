package service;

import dao.PlantDao;
import dao.PlantProfileDao;
import dao.UserDao;
import model.domain.IUser;
import model.PlantList;
import model.PlantProfileList;
import model.domain.User;
import utils.exceptions.InvalidPasswordException;
import utils.exceptions.UserAlreadyExists;
import utils.exceptions.UserNotFoundException;

import java.sql.SQLException;
import java.text.ParseException;

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
    public IUser getUserById(String userID) throws SQLException, ParseException {
        PlantProfileList profileList = plantProfileDao.getPlantProfiles(userID);
        PlantList plantList = plantDao.getPlants(userID);
        IUser user = new User(userID, profileList, plantList);
        return user;
    }

    @Override
    public void deleteUser(String email) throws SQLException {
        userDao.delete(email);
    }

    @Override
    public void updateUser(IUser user) throws SQLException {
        userDao.updateUser(user);
    }

    @Override
    public boolean createUser(IUser user) throws SQLException, UserAlreadyExists {
        if (!userDao.userExists(user.getEmail())){
            userDao.createUser(user);
            return true;
        }else {
            throw new UserAlreadyExists();
        }
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
