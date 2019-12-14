package dao;

import model.domain.IUser;
import model.domain.User;
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

    public void updateUser(String email, IUser user) throws SQLException {
        db.update(Queries.UPDATE_USER, user.getEmail(), user.getPassword(), email);
    }

    public IUser getUserByEmail(String email) throws SQLException {
        ArrayList<Object[]> result = db.query(Queries.GET_USER, email);
        IUser user = null;
        if(result.size() == 1){
            String password = result.get(0)[0].toString();
            user = new User(email,password);
        }
        return user;
    }
}
