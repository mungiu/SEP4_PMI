package service;

import model.domain.IUser;
import utils.exceptions.InvalidPasswordException;
import utils.exceptions.MissingDataException;
import utils.exceptions.UserAlreadyExists;
import utils.exceptions.UserNotFoundException;

import java.sql.SQLException;
import java.text.ParseException;

public interface IUserService {
    IUser getUserById(String userID) throws SQLException, ParseException, UserNotFoundException;
    void deleteUser(String email) throws  SQLException;
    void updateUser(String email,IUser user) throws  SQLException;
    boolean createUser(IUser user) throws SQLException, UserAlreadyExists, MissingDataException;
    boolean login(IUser user) throws InvalidPasswordException, UserNotFoundException, SQLException;

}
