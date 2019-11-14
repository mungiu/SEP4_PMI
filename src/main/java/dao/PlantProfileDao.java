package dao;

import java.sql.SQLException;

import model.PlantProfile;
import model.PlantProfileList;
import utils.Database;
import utils.Queries;

public class PlantProfileDao {
	private static PlantProfileDao instance;
	private Database db;
	
	private PlantProfileDao() {
		db = Database.getInstance();
	}
	
	public static PlantProfileDao getInstance() {
		if(instance == null) {
			instance = new PlantProfileDao();
		}
		return instance;
	}
	
	public void createPlantProfile(PlantProfile plantProfile, String OwnerId) throws SQLException{
		try { 
			db.update(Queries.CREATE_PLANT_PROFILE, OwnerId, plantProfile.getName(), 
					plantProfile.getCo2().getMax(), plantProfile.getCo2().getMin(),
					plantProfile.getHumidity().getMax(), plantProfile.getHumidity().getMin(),
					plantProfile.getTemperature().getMax(), plantProfile.getTemperature().getMin(),
					plantProfile.getLight().getMax(), plantProfile.getLight().getMin());
			
		} catch (SQLException e) {
			throw e;
		}
		
	}

	public PlantProfileList getPlantProfiles(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	public void updatePlantProfile(PlantProfile plantProfile) {
		// TODO Auto-generated method stub
		
	}

	public void deletePlantProfile(String plantProfileID) {
		// TODO Auto-generated method stub
		
	}
}
