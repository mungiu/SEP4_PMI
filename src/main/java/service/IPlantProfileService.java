package service;

import model.domain.PlantProfile;
import utils.exceptions.MissingDataException;

import java.sql.SQLException;

public interface IPlantProfileService {
    PlantProfile getPlantProfileById(String plantID)throws SQLException;
    void updatePlantProfile(PlantProfile plantProfile) throws SQLException, MissingDataException;
    void deletePlantProfile(String plantProfileID) throws SQLException;
	void createPlantProfile(PlantProfile plantProfile) throws SQLException, MissingDataException;

}
