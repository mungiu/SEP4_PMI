package service;

import dao.PlantProfileDao;
import model.domain.PlantProfile;
import utils.exceptions.MissingDataException;

import java.sql.SQLException;

public class PlantProfileService implements IPlantProfileService {

    private PlantProfileDao dao;

    public PlantProfileService() {
        dao = new PlantProfileDao();
    }

    @Override
    public void createPlantProfile(PlantProfile plantProfile) throws SQLException, MissingDataException {
        if(isValid(plantProfile)){
            dao.createPlantProfile(plantProfile);
        } else {
            throw new MissingDataException("PlantProfile didn't contain all required data");
        }
    }

    @Override
    public PlantProfile getPlantProfileById(String plantID) throws SQLException {
        return dao.getPlantProfileById(plantID);
    }


    @Override
    public void updatePlantProfile(PlantProfile plantProfile) throws SQLException, MissingDataException {
        if(isValid(plantProfile)){
            dao.updatePlantProfile(plantProfile);
        } else {
            throw new MissingDataException("PlantProfile didn't contain all required data");
        }
    }


    @Override
    public void deletePlantProfile(String plantProfileID) throws SQLException {
        dao.deletePlantProfile(plantProfileID);
    }

    private boolean isValid(PlantProfile plantProfile) {
        return plantProfile != null
                && plantProfile.getName() != null && plantProfile.getUserEmail() != null
                && plantProfile.getTemperatureBoundaries() != null && plantProfile.getTemperatureBoundaries().isValid()
                && plantProfile.getLightBoundaries() != null && plantProfile.getLightBoundaries().isValid()
                && plantProfile.getCo2Boundaries() != null && plantProfile.getCo2Boundaries().isValid()
                && plantProfile.getHumidityBoundaries() != null && plantProfile.getHumidityBoundaries().isValid();
    }


}
