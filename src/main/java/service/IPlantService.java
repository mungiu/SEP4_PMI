package service;

import model.IPlant;

import java.sql.SQLException;

public interface IPlantService {
    IPlant getPlantById(String plantID) throws SQLException;
    void deletePlant(String plantID) throws  SQLException;
    void updatePlant(IPlant plant) throws  SQLException;
    void createPlant(IPlant plant) throws SQLException;
}
