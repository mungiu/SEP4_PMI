package service;

import model.PlantProfile;
import model.PlantProfileList;

import java.sql.SQLException;

public interface IPlantProfileService {
    PlantProfile getPlantProfileById(String plantProfileID) throws SQLException;
    PlantProfileList getMyPlantProfiles(String userID) throws SQLException;
    void createPlantProfile(PlantProfile plantProfile) throws SQLException;
    void updatePlantProfile(PlantProfile plantProfile) throws SQLException;
    void deletePlantProfile(String plantProfileID) throws SQLException;
}
