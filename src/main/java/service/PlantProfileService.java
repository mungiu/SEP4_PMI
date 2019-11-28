package service;

import dao.PlantProfileDao;
import model.PlantProfile;

import java.sql.SQLException;

public class PlantProfileService implements IPlantProfileService {

    private PlantProfileDao dao;

    public PlantProfileService() {
        dao = new PlantProfileDao();
    }

    @Override
    public void createPlantProfile(PlantProfile plantProfile) throws SQLException {
        if(isValid(plantProfile)){
            dao.createPlantProfile(plantProfile);
        } else{
           // throw new utils.exceptions.InvalidFormException("Invalid plant info");
        }
    }

    @Override
    public PlantProfile getPlantProfileById(String plantID) throws SQLException {
        return dao.getPlantProfileById(plantID);
    }


    @Override
    public void updatePlantProfile(PlantProfile plantProfile) throws SQLException {
        if(isValid(plantProfile)){
            dao.updatePlantProfile(plantProfile);
        } else {
            //throw new InvalidFormException("Invalid plant info");
        }
    }


    @Override
    public void deletePlantProfile(String plantProfileID) throws SQLException {
        dao.deletePlantProfile(plantProfileID);
    }

    // TODO: Simplify the if statement or create a custom exception
    private boolean isValid(PlantProfile plantProfile) {
        if (plantProfile == null || plantProfile.getName() == null
                || plantProfile.getTemperature() == null || plantProfile.getLight() == null
                || plantProfile.getCo2() == null || plantProfile.getHumidity() == null
                || !plantProfile.getCo2().isValid() || !plantProfile.getHumidity().isValid()
                || !plantProfile.getLight().isValid() || !plantProfile.getTemperature().isValid()
                || plantProfile.getUser() == null || plantProfile.getUser().getEmail() == null) {
            return false;
        }
        else {
            return true;
        }
    }


}
