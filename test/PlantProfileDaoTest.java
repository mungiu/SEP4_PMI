import dao.PlantDao;
import dao.PlantProfileDao;
import dao.UserDao;
import model.PlantList;
import model.PlantProfileList;
import model.SensorBoundaries;
import model.domain.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import utils.Database;
import utils.Queries;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

public class PlantProfileDaoTest {

    private UserDao userDao;
    private PlantProfileDao profileDao;

    private IPlantProfile profile;
    private IPlantProfile newProfile;
    private PlantProfileList profileList;
    private final IUser USER  = new User("IamATestUser@never.com", "1234567890");
    private final String EMAIL = "IamATestUser@never.com";


    @Before
    public void setUp() throws SQLException {
        profileDao = new PlantProfileDao();
        setUpUser();
        setUpProfiles();
    }

    @After
    public void tearDown() throws SQLException {
        deleteTestProfiles();
        deleteUser();
    }

    @Test
    public void testGetProfiles(){
        try{
            PlantProfileList profileList = profileDao.getPlantProfiles("naya7777@gmail.com");
            assertEquals("Yeet",profileList.getPlantProfiles().get(0).getName());
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Test
    public void testCreatePlantProfile() throws SQLException {
        SensorBoundaries CO2 = new SensorBoundaries(1.0, 75.0);
        SensorBoundaries Temp = new SensorBoundaries(10.0, 45.0);
        SensorBoundaries Hum = new SensorBoundaries(1.0, 10.0);
        SensorBoundaries light = new SensorBoundaries(20.0, 60.0);
        IPlantProfile newProfile = new PlantProfile("TestProfile16-12", USER.getEmail(), CO2, Temp, Hum, light );
        profileDao.createPlantProfile(newProfile);
        profileList = profileDao.getPlantProfiles(EMAIL);
        assertNotEquals(null, findProfile(newProfile));
    }

    @Test
    public void testDeleteProfile() throws SQLException {
        profileDao.deletePlantProfile(profile.getId());
        assertNotNull(findProfile(profile));

    }

    @Test
    public void testUpdateProfileName() throws SQLException {
        profile.setName("TestTestTesHello");
        profileDao.updatePlantProfile(profile);
        assertNotEquals("MyPPNameISSSSSSSomething", profile.getName());
    }

    @Test
    public void updateProfileCO2() throws SQLException {
        SensorBoundaries newCo2 = new SensorBoundaries(1.11 , 55.5);
        boolean isChanged = false;
        profile.setCo2Boundaries(newCo2);
        profileDao.updatePlantProfile(profile);
        PlantProfileList list = profileDao.getPlantProfiles(USER.getEmail());
        for (IPlantProfile plantProfile: list.getPlantProfiles()) {
            if (!(plantProfile.getCo2Boundaries().equals(profile.getCo2Boundaries())) ){
                isChanged = true;
            }
        }

        assertTrue(isChanged);
    }

    @Test
    public void updateProfileHum() throws SQLException {
        SensorBoundaries newHum = new SensorBoundaries(1.11 , 55.5);
        boolean isChanged = false;
        profile.setCo2Boundaries(newHum);
        profileDao.updatePlantProfile(profile);
        PlantProfileList list = profileDao.getPlantProfiles(USER.getEmail());
        for (IPlantProfile plantProfile: list.getPlantProfiles()) {
            if (!(plantProfile.getHumidityBoundaries().equals(profile.getHumidityBoundaries())) ){
                isChanged = true;
            }
        }

        assertTrue(isChanged);
    }

    @Test
    public void updateProfileTemp() throws SQLException {
        SensorBoundaries newTemp = new SensorBoundaries(1.11 , 55.5);
        boolean isChanged = false;
        profile.setTemperatureBoundaries(newTemp);
        profileDao.updatePlantProfile(profile);
        PlantProfileList list = profileDao.getPlantProfiles(USER.getEmail());
        for (IPlantProfile plantProfile: list.getPlantProfiles()) {
            if (!(plantProfile.getTemperatureBoundaries().equals(profile.getTemperatureBoundaries())) ){
                isChanged = true;
            }
        }

        assertTrue(isChanged);
    }

    @Test
    public void updateProfileLight() throws SQLException {
        SensorBoundaries newLight = new SensorBoundaries(1.11 , 55.5);
        boolean isChanged = false;
        profile.setLightBoundaries(newLight);
        profileDao.updatePlantProfile(profile);
        PlantProfileList list = profileDao.getPlantProfiles(USER.getEmail());
        for (IPlantProfile plantProfile: list.getPlantProfiles()) {
            if (!(plantProfile.getLightBoundaries().equals(profile.getLightBoundaries())) ){
                isChanged = true;
            }
        }

        assertTrue(isChanged);
    }


































    private void setUpUser() throws SQLException {
        userDao = new UserDao();
        userDao.createUser(USER);
    }


    private void setUpProfiles() throws SQLException {
        SensorBoundaries boundaries = new SensorBoundaries(1.0, 2.0);
        profile = new PlantProfile("MyPPNameISSSSSSSomething" , "IamATestUser@never.com", boundaries,boundaries,boundaries,boundaries);
        profileDao.createPlantProfile(profile);
        profileList = profileDao.getPlantProfiles("IamATestUser@never.com");
    }

    private void deleteTestProfiles() throws SQLException {
        profileList = profileDao.getPlantProfiles(EMAIL);
        for(IPlantProfile profile: profileList.getPlantProfiles()){
            profileDao.deletePlantProfile(profile.getId());
        }
    }

    private void deleteUser() throws SQLException {
        userDao.delete(EMAIL);
    }

    private boolean sameProfiles(IPlantProfile profile1, IPlantProfile profile2) {
        return profile1.getName().equals(profile2.getName());
    }
    private IPlantProfile findProfile(IPlantProfile profileToBeFound) throws SQLException {
        profileList = profileDao.getPlantProfiles(EMAIL);
        for (IPlantProfile profile :profileList.getPlantProfiles()) {
            if(sameProfiles(profile,profileToBeFound)){
                return profile;
            }
        }
        return null;
    }



   /* @Before
    public void setup() throws SQLException {
        user1 = new User("test2PlantProfileDao@gmail.com", "1111");
        daoUser = new UserDao();
        daoUser.createUser(user1);
        SensorBoundaries CO2 = new SensorBoundaries(1.0, 75.0);
        SensorBoundaries Temp = new SensorBoundaries(10.0, 45.0);
        SensorBoundaries Hum = new SensorBoundaries(1.0, 10.0);
        SensorBoundaries light = new SensorBoundaries(20.0, 60.0);
        profile = new PlantProfile("Test Profile name", user1.getEmail(), CO2 , Temp,
                Hum, light);
        dao = new PlantProfileDao();
        dao.createPlantProfile(profile);
    }


    @After
    public void tearDown() throws SQLException {
        dao.deletePlantProfile(profile.getId());
        daoUser.delete(user1.getEmail());
    }

    @Test
    public void testGetProfiles(){
        try{
            PlantProfileList profileList = dao.getPlantProfiles("naya7777@gmail.com");
            assertEquals("naya flower 1",profileList.getPlantProfiles().get(0).getName());
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Test
    public void testCreateProfile() throws SQLException {
        dao.createPlantProfile(profile);

    }
    @Test
    public void deleteProfile() throws SQLException {
        dao.deletePlantProfile(profile.getId());
    }

    @Test
    public void updateProfileName() throws SQLException {
        String currentName = profile.getName();
        profile.setName("new Name");
        dao.updatePlantProfile(profile);
        IPlantProfile temp = dao.getPlantProfileById(profile.getId());
        assertEquals(profile.getName(), temp.getName());
    }
    @Test
    public void updateProfileCO2() throws SQLException {
        double currentMax = profile.getCo2Boundaries().getMax();
        double currentMin = profile.getCo2Boundaries().getMin();
        SensorBoundaries newCo2 = new SensorBoundaries(0.01 , 50.0);
        boolean isChanged = false;
        profile.setCo2Boundaries(newCo2);
        dao.updatePlantProfile(profile);
        PlantProfileList list = dao.getPlantProfiles(user1.getEmail());
        for (IPlantProfile plantProfile: list.getPlantProfiles()) {
            if (!(plantProfile.getCo2Boundaries().equals(profile.getCo2Boundaries())) ){
                isChanged = true;
            }
        }

        assertTrue(isChanged);
    }
*/





}
