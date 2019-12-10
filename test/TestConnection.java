import org.junit.Before;
import org.junit.Test;
import utils.Database;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class TestConnection {
    Database db;
    private static final String GET_PLANT_NAME_WITH_ID_1 = "select plantname from dbo.Plant where plant_id = 1";

    @Before
    public void setup(){
        db = Database.getInstance();
    }

    @Test
    public void getNewConnectionTest(){
        Connection conn = db.getNewConnection();
        assertNotEquals(null,conn);
    }

    @Test
    public void getSomethingFromDB() throws SQLException {
        Connection conn = db.getNewConnection();
        ArrayList<Object[]> result = db.query(GET_PLANT_NAME_WITH_ID_1);
        String plantName = result.get(0)[0].toString();
    }



}
