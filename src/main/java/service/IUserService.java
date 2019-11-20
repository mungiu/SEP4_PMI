package service;

import model.User;

import java.sql.SQLException;

public interface IUserService {
    User getUserById(String userID) throws SQLException;
    void deleteUser(String userID) throws  SQLException;
    void updateUser(User user) throws  SQLException;
    void createUser(User user) throws SQLException;
}
