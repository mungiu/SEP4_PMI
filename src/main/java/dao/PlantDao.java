package dao;

import java.sql.SQLException;

import model.Plant;
import model.PlantList;
import utils.Database;
import utils.Queries;

public class PlantDao {
	private static PlantDao instance;
	private Database db;
	
	private PlantDao() {
		db = Database.getInstance();
	}
	
	public static PlantDao getInstance() {
		if(instance == null) {
			instance = new PlantDao();
		}
		return instance;
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
}
