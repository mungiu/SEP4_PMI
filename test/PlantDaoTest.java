import dao.PlantDao;
import model.domain.Plant;
import model.PlantList;
import model.domain.PlantProfile;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.text.ParseException;

public class PlantDaoTest {
    PlantDao dao;

    @Before
    public void setup(){
        dao = new PlantDao();
    }

    @Test
    public void testGetPlantsByUserId(){
        try {
            PlantList plantList = dao.getPlants("naya7777@gmail.com");
            for (int i = 0; i < plantList.size(); i++) {
                System.out.println(plantList.getPlant(i).getPlantName());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCreatePlant(){
        try {
            PlantProfile profile = new PlantProfile();
            profile.setId(3);
            Plant plant = new Plant("plant test",profile);
            dao.createPlant(plant);
            PlantList plantList = dao.getPlants("naya7777@gmail.com");
            for (int i = 0; i < plantList.size(); i++) {
                System.out.println(plantList.getPlant(i).getPlantName());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
