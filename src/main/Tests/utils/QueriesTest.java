package utils;

import model.User;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class QueriesTest {

    Database database = Database.getInstance();

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @Test
    public void insertQueries() throws SQLException {

    User testUser = new User();
    testUser.setEmail("testuset836358@test.gov");
    testUser.setPassword("hardToGuess");
    ArrayList<User> arrUser = new ArrayList<User>();
    arrUser.add(testUser);

    /*ArrayList<Object[]> returnedUser = (ArrayList<Object[]>) */
    database.query(Queries.GET_USER,arrUser);
    /*assertTrue(returnedUser.size()==0);*/
    //database.query(Queries.CREATE_USER, arrUser);


    }
}