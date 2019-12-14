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

public class UserDaoTest {

    User user1;
    UserDao dao;
    User userCreate;

    @Before
    public void setUp() throws Exception {
        user1 = new User("test1@gmail.com", "1111");
        dao = new UserDao();
        dao.createUser(user1);
        userCreate = new User("testCreateUser@gmail.com","1234567890");
    }

    @After
    public void tearDown() throws SQLException {
        dao.delete(user1.getEmail());
        dao.delete(userCreate.getEmail());
    }

    @Test
    public void createUserIfDoesntExist() {
        try {
            dao.createUser(userCreate);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void userExistsTestWhenExists() {
        try {
            assertTrue(dao.userExists(user1.getEmail()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void userExistsTestWhenNotExists() {
        try {
            assertFalse(dao.userExists(userCreate.getEmail()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void ifValidWhenUserIsValid() {
        try {
            assertTrue(dao.validLogin(user1));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void ifValidWhenUserIsNotValid() {
        try {
            assertFalse(dao.validLogin(userCreate));
        } catch (SQLException e) {
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
