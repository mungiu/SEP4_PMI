package service;

import dao.UserDao;
import model.domain.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import utils.exceptions.InvalidPasswordException;
import utils.exceptions.UserAlreadyExists;
import utils.exceptions.UserNotFoundException;

import java.sql.SQLDataException;
import java.sql.SQLException;
import java.text.ParseException;

import static org.junit.Assert.*;

public class UserServiceTest {

    IUserService userService;
    User user1;
    UserDao dao;

    @Before
    public void setUp() throws Exception {
        userService = new UserService();
        user1 = new User("test1@gmail.com", "1111");
        dao = new UserDao();
    }
    @After
    public void tearDown() throws SQLException {
        dao.delete(user1.getEmail());
    }

    @Test
    public void createUser() {
        try {
            assertTrue(userService.createUser(user1));
        } catch (SQLException | UserAlreadyExists e) {
            e.printStackTrace();
        }

    }


    @Test
    public void login() throws SQLException, UserNotFoundException, InvalidPasswordException {
        dao.createUser(user1);
        dao.validLogin(user1);
        assertTrue(userService.login(user1));
    }
}
