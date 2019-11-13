package service;

import model.Plant;
import model.PlantList;
import utils.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PlantService implements IPlantService {

    public PlantService() {
        // this.connection = dbConnection;
    }

    /**
     * todo
     */
    @Override
    public PlantList getAllPlants() throws SQLException {
        return null;
    }

    /**
     * todo
     */
    public Plant getPlantById(String plantID) throws SQLException {
        return null;
    }

    /**
     * todo
     */
    public void createPlant(Plant plant) throws SQLException {
    }

    /**
     * todo
     */
    @Override
    public void updatePlant(Plant plant) throws SQLException {
    }

    /**
     * todo
     */
    @Override
    public void deletePlant(String plantID) throws SQLException {
    }
}




