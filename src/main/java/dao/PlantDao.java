package dao;

import java.sql.SQLException;

import model.Plant;
import model.PlantList;
import utils.Database;
import utils.Queries;

public class PlantDao {
	private Database db;
	
	public PlantDao() {
		db = Database.getInstance();
	}

	
	public void createPlant(Plant plant) throws SQLException{
		try { 
			db.update(Queries.CREATE_PLANT, plant.getProfile().getId(), plant.getName());
			
		} catch (SQLException e) {
			throw e;
		}
		
	}

	public void deletePlant(String plantID) {
		// TODO Auto-generated method stub
		
	}

	public void updatePlate(Plant plant) {
		// TODO Auto-generated method stub
		
	}

	public PlantList getPlants(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

    public Plant getPlantById(String plantID) {
		// TODO
		return null;
    }
}
