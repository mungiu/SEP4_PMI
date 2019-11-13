package dao;

import java.sql.SQLException;

import model.Plant;
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
}
