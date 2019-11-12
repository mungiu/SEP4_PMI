package service;

import model.Plant;
import model.PlantList;
import utils.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dao.PlantDao;

public class PlantService implements IPlantService {

    private PlantDao dao;
	
	public PlantService() {
		dao = PlantDao.getInstance();
	}

    /**
     * todo
     */
    public void createPlant(Plant plant) throws SQLException {
    	dao.createPlant(plant);
    }

    /**
     * todo
     */
    @Override
    public void updatePlant(Plant plant) throws SQLException {
    	dao.updatePlate(plant);
    }

    /**
     * todo
     */
    @Override
    public void deletePlant(String plantID) throws SQLException {
    	dao.deletePlant(plantID);
    }

	@Override
	public PlantList getAllPlants(String userId) throws SQLException {
		return dao.getPlants(userId);
	}
}




