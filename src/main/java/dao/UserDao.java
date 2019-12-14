package dao;

import model.domain.IUser;
import utils.Database;
import utils.Queries;

import java.sql.SQLException;
import java.util.ArrayList;

public class UserDao {
    private Database db;

    public UserDao() {
        db = Database.getInstance();
    }

    public boolean userExists(String email) throws SQLException {
        ArrayList<Object[]> result = db.query(Queries.GET_USER_ID_BY_EMAIL, email);
        if(result.size() == 1){
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean validLogin(IUser user) throws SQLException {
        ArrayList<Object[]> result = db.query(Queries.GET_USER_ID_BY_EMAIL_AND_PASSWORD, user.getEmail(), user.getPassword());
        if(result.size() == 1){
            return true;
        }
        else
        {
            return false;
        }
    }

    public void createUser(IUser user) throws SQLException {
        db.update(Queries.CREATE_USER, user.getEmail(), user.getPassword());
    }
    public void delete(String email) throws SQLException {
        db.update(Queries.DELETE_USER, email);
    }

    public void updateUser(IUser user) throws SQLException {
        db.update(Queries.UPDATE_USER, user.getEmail(), user.getPassword());
    }
}
