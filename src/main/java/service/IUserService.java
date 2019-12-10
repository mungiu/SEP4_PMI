package service;

import model.domain.IUser;
import utils.exceptions.InvalidPasswordException;
import utils.exceptions.UserNotFoundException;

import java.sql.SQLException;
import java.text.ParseException;

public interface IUserService {
    IUser getUserById(String userID) throws SQLException, ParseException;
    void deleteUser(String userID) throws  SQLException;
    void updateUser(IUser user) throws  SQLException;
    void createUser(IUser user) throws SQLException;
    boolean login(IUser user) throws InvalidPasswordException, UserNotFoundException, SQLException;
}
