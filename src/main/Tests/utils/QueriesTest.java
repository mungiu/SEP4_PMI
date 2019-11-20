package utils;

import model.Plant;
import model.User;
import org.junit.Test;

import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.AssertTrue;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class QueriesTest {

    Queries queries = new Queries();

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @Test
    public void getPlantsByUser() throws Exception {

        ArrayList<Plant> tempPlants = queries.getPlantsByUserID("not_in_database344");
        assertTrue(tempPlants==null);
        ArrayList<Plant> tempPlants2 = queries.getPlantsByUserID("ziad7777@gmail.com");
        assertTrue(tempPlants2.size()==1);




    /*
    User testUser = new User();
    testUser.setEmail("testuset836358@test.gov");
    testUser.setPassword("hardToGuess");
    ArrayList<User> arrUser = new ArrayList<User>();
    arrUser.add(testUser);

    /*ArrayList<Object[]> returnedUser = (ArrayList<Object[]>) */
    /*database.query(Queries.GET_USER,arrUser);*/
    /*assertTrue(returnedUser.size()==0);*/
    //database.query(Queries.CREATE_USER, arrUser);



    }
}