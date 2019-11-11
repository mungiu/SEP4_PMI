package dao;

import java.sql.SQLException;

import model.PlantProfile;
import utils.Database;
import utils.Queries;

public class PlantProfileDao {
	private Database db;
	
	public PlantProfileDao() {
		db = Database.getInstance();
	}
	
	public void createPlantProfile(PlantProfile plantProfile) throws SQLException{
		try { 
			db.update(Queries.CREATE_PLANT_PROFILE, plantProfile.getUser().getEmail(), plantProfile.getName(), 
					plantProfile.getCo2().getMax(), plantProfile.getCo2().getMin(),
					plantProfile.getHumidity().getMax(), plantProfile.getHumidity().getMin(),
					plantProfile.getTemperature().getMax(), plantProfile.getTemperature().getMin(),
					plantProfile.getLight().getMax(), plantProfile.getLight().getMin());
			
		} catch (SQLException e) {
			throw e;
		}
		
	}
}
