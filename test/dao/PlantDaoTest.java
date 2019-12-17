package dao;

import model.PlantList;
import model.PlantProfileList;
import model.SensorBoundaries;
import model.domain.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.sql.SQLException;

public class PlantDaoTest {
    private PlantDao dao;
    private UserDao userDao;
    private PlantProfileDao profileDao;
    private IPlant createdPlant;
    private PlantProfileList profileList;
    private PlantList plantList;
    private final IUser USER  = new User("IamATestUser@never.com", "1234567890");
    private final String EMAIL = "IamATestUser@never.com";

    @Before
    public void setUp() throws SQLException {
        dao = new PlantDao();
        profileDao = new PlantProfileDao();
        setUpUser();
        setUpProfiles();
        setUpPlants();
    }

    @After
    public void tearDown() throws SQLException {
        deleteTestPlants();
        deleteTestProfiles();
        deleteUser();
    }

    @Test
    public void testCreatePlant() throws SQLException {
        IPlant newPlant = new Plant("IAMADEVICEIDFORTESTPURPOSE", "AReallyCoolPlantNameTest", profileList.getPlantProfiles().get(0).getId());
        dao.createPlant(newPlant);
        plantList = dao.getPlants(EMAIL);
        assertNotEquals(null, findPlant(newPlant));
    }

    @Test
    public void testDeletePlant() throws SQLException {
        dao.deletePlant(createdPlant.getPlantId());
        plantList = dao.getPlants(EMAIL);
        assertNull(findPlant(createdPlant));
    }

    @Test
    public void testUpdatePlantDeviceId() throws SQLException {
        createdPlant.setDeviceId("MYNEWDEVICEIDISSOCOOOOOOOOOL");
        dao.updatePlant(createdPlant);
        assertNotNull(findPlant(createdPlant));
    }

    @Test
    public void testUpdatePlantName() throws SQLException {
        createdPlant.setPlantName("MYNEWNAMEISSOCOOOOOOOOOL");
        dao.updatePlant(createdPlant);
        assertNotNull(findPlant(createdPlant));
    }

    @Test (expected = SQLException.class)
    public void testUpdateProfileIDWithInvalidProfileID() throws SQLException {
        createdPlant.setPlantProfileId(123456789);
        dao.updatePlant(createdPlant);
    }

    @Test
    public void testUpdateProfileIDWithValidProfileID() throws SQLException {
        setUpProfiles();
        int newPlantProfileId = plantList.getPlants().get(plantList.size()-1).getPlantProfileId();
        createdPlant.setPlantProfileId(newPlantProfileId);
        dao.updatePlant(createdPlant);
        assertNotNull(findPlant(createdPlant));
    }

    @Test
    public void testGetPlantsWhenUserHasNoPlants() throws SQLException {
        dao.deletePlant(createdPlant.getPlantId());
        plantList = dao.getPlants(EMAIL);
        assertEquals(0, plantList.size());
    }

    @Test
    public void testGetPlantsWhenUserHasOnePlant() throws SQLException {
        plantList = dao.getPlants(EMAIL);
        assertEquals(1, plantList.size());
    }



    private void setUpUser() throws SQLException {
        userDao = new UserDao();
        userDao.createUser(USER);
    }

    private void setUpProfiles() throws SQLException {
        SensorBoundaries boundaries = new SensorBoundaries(1.0, 2.0);
        IPlantProfile profile = new PlantProfile("MyPPNameISSSSSSSomething", "IamATestUser@never.com", boundaries, boundaries, boundaries, boundaries);
        profileDao.createPlantProfile(profile);
        profileList = profileDao.getPlantProfiles("IamATestUser@never.com");
    }

    private void setUpPlants() throws SQLException {
        if(profileList.size() >= 1){
            createdPlant = new Plant("MyDeviceIDIsSoUniqueCauseIAmJustATest", "MyNameIsAlsoSoUniqueCauseIAmAlsoATest", profileList.getPlantProfiles().get(0).getId());
            dao.createPlant(createdPlant);
            plantList = dao.getPlants(EMAIL);
            for (IPlant plant:plantList.getPlants()) {
                if(samePlants(plant, createdPlant)){
                    createdPlant = plant;
                }
            }
        }
    }

    private boolean samePlants(IPlant plant1, IPlant plant2) {
        return plant1.getPlantName().equals(plant2.getPlantName()) && plant1.getDeviceId().equals(plant2.getDeviceId()) && plant1.getPlantProfileId() == plant2.getPlantProfileId();
    }

    private void deleteTestProfiles() throws SQLException {
        profileList = profileDao.getPlantProfiles(EMAIL);
        for(IPlantProfile profile: profileList.getPlantProfiles()){
            profileDao.deletePlantProfile(profile.getId());
        }
    }


    private void deleteTestPlants() throws SQLException {
        plantList = dao.getPlants(EMAIL);
        for (IPlant plant: plantList.getPlants()) {
            dao.deletePlant(plant.getPlantId());
        }
    }

    private void deleteUser() throws SQLException {
        userDao.delete(EMAIL);
    }

    private IPlant findPlant(IPlant plantToBeFound) throws SQLException {
        plantList = dao.getPlants(EMAIL);
        for (IPlant plant :plantList.getPlants()) {
            if(samePlants(plant,plantToBeFound)){
                return plant;
            }
        }
        return null;
    }

}
