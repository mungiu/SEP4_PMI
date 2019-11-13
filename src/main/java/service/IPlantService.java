package service;

import model.Plant;
import model.PlantList;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IPlantService {

    Plant getPlantById(String plantID) throws SQLException;
    PlantList getAllPlants() throws SQLException;
    void deletePlant(String plantID) throws  SQLException;
    void updatePlant(Plant plant) throws  SQLException;
    void createPlant(Plant plant) throws SQLException;
}
