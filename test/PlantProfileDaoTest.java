import dao.PlantProfileDao;
import model.PlantProfileList;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

public class PlantProfileDaoTest {

    private PlantProfileDao dao;

    @Before
    public void setup(){
        dao = new PlantProfileDao();
    }

    @Test
    public void testGetProfiles(){
        try{
            PlantProfileList profileList = dao.getPlantProfiles("naya7777@gmail.com");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Test
    public void testCreateProfile(){

    }


}
