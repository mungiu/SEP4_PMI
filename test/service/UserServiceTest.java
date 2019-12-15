package service;

import model.domain.IUser;
import model.domain.User;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import utils.exceptions.InvalidPasswordException;
import utils.exceptions.UserAlreadyExists;
import utils.exceptions.UserNotFoundException;

import java.sql.SQLException;
import java.text.ParseException;

import static org.junit.Assert.*;

public class UserServiceTest {
    User user1;
    User userCreate;
    IUserService service;

    @Before
    public void setUp() throws SQLException, UserAlreadyExists {
        user1 = new User("testUserService@gmail.com", "1111");
        service = new UserService();
        service.createUser(user1);
        userCreate = new User("testCreateUserService@gmail.com","1234567890");
    }

    @After
    public void tearDown() throws SQLException {
        service.deleteUser(user1.getEmail());
        service.deleteUser(userCreate.getEmail());
    }

    @Test
    public void testGetUser() throws SQLException, ParseException, UserNotFoundException {
        IUser userFromDb = service.getUserById("testUserService@gmail.com");
        assertEquals("testUserService@gmail.com", userFromDb.getEmail());
    }

    @Test
    public void testChangePassword() throws SQLException, UserNotFoundException, InvalidPasswordException {
        user1.setPassword("ChangedPassword");
        service.updateUser("testUserService@gmail.com", user1);
        assertEquals(true, service.login(user1));
    }

    @Test
    public void testLoginSucceed() throws SQLException, UserNotFoundException, InvalidPasswordException {
        assertEquals(true, service.login(user1));
    }

    @Test (expected = UserNotFoundException.class)
    public void testLoginUserNotFound() throws SQLException, UserNotFoundException, InvalidPasswordException {
        IUser userWrongInfo = new User("wrongemail1234567890@gmail.com", "wrongpassword");
        service.login(userWrongInfo);
    }

    @Test (expected = InvalidPasswordException.class)
    public void testInvalidPassword() throws SQLException, UserNotFoundException, InvalidPasswordException {
        user1.setPassword("wrongpassword456789");
        service.login(user1);
    }

    @Test
    public void testCreateNewUser() throws SQLException, UserAlreadyExists, ParseException, UserNotFoundException {
        service.createUser(userCreate);
        IUser userFromDb = service.getUserById("testCreateUserService@gmail.com");
        assertEquals("testCreateUserService@gmail.com", userFromDb.getEmail());
    }

    @Test (expected = UserNotFoundException.class)
    public void testDeleteUser() throws SQLException, ParseException, UserNotFoundException {
        service.deleteUser(user1.getEmail());
        service.getUserById(user1.getEmail());
    }

    @Test (expected = UserAlreadyExists.class)
    public void testCreateUserThatAlreadyExist() throws SQLException, UserAlreadyExists {
        service.createUser(user1);
    }



}
