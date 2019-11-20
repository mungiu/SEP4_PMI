package dao;

import java.sql.SQLException;

import model.PlantProfile;
import model.PlantProfileList;
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

	public PlantProfileList getPlantProfiles(String userId) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public void updatePlantProfile(PlantProfile plantProfile) throws SQLException{
		// TODO Auto-generated method stub
		
	}

	public void deletePlantProfile(String plantProfileID) throws SQLException{
		// TODO Auto-generated method stub
		
	}

	public PlantProfile getPlantProfileById(String plantID) throws SQLException{
		return null;
	}
}
