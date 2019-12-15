package dao;

import model.*;
import model.domain.*;
import utils.Database;
import utils.Queries;

import java.sql.SQLException;
import java.util.ArrayList;

public class PlantProfileDao {
	private Database db;
	
	public PlantProfileDao() {
		db = Database.getInstance();
	}

	
	public void createPlantProfile(IPlantProfile plantProfile) throws SQLException{
		try {
			db.update(Queries.CREATE_PLANT_PROFILE, plantProfile.getUserEmail(), plantProfile.getName(),
					plantProfile.getCo2Boundaries().getMax(), plantProfile.getCo2Boundaries().getMin(),
					plantProfile.getHumidityBoundaries().getMax(), plantProfile.getHumidityBoundaries().getMin(),
					plantProfile.getTemperatureBoundaries().getMax(), plantProfile.getTemperatureBoundaries().getMin(),
					plantProfile.getLightBoundaries().getMax(), plantProfile.getLightBoundaries().getMin());

		} catch (SQLException e) {
			throw e;
		}
	}

	public PlantProfileList getPlantProfiles(String userId) throws SQLException {
		try{
			ArrayList<Object[]> result = db.query(Queries.GET_PLANT_PROFILES, userId);
			PlantProfileList profiles = new PlantProfileList();
			for (Object[] row: result) {
				/*"select PP.Profile_Name, "+
						"PP.CO2_Max, PP.CO2_Min, "+
						"PP.Hum_Max, PP.Hum_Min, "+
						"PP.Tem_Max, PP.Tem_Min, "+
						"PP.Light_Max, PP.Light_Min "+
						"from dbo.PlantProfile PP where user_ID = ?;";*/
				int profileId = Integer.parseInt(row[0].toString());
				String profileName = row[1].toString();
				int co2Max = Integer.parseInt(row[2].toString());
				int co2Min = Integer.parseInt(row[3].toString());
				int humidityMax = Integer.parseInt(row[4].toString());
				int humidityMin = Integer.parseInt(row[5].toString());
				int temperatureMax = Integer.parseInt(row[6].toString());
				int temperatureMin = Integer.parseInt(row[7].toString());
				int lightMax = Integer.parseInt(row[8].toString());
				int lightMin = Integer.parseInt(row[9].toString());
				IUser user = new User();
				user.setEmail(userId);
				SensorBoundaries co2 = new SensorBoundaries(co2Min,co2Max);
				SensorBoundaries humidity = new SensorBoundaries(humidityMin,humidityMax);
				SensorBoundaries temperature = new SensorBoundaries(temperatureMin,temperatureMax);
				SensorBoundaries light = new SensorBoundaries(lightMin,lightMax);
				IPlantProfile profile = new PlantProfile(profileId,profileName,user.getEmail(),co2,temperature,humidity,light);
				profiles.addPlantProfile(profile);
			}
			return profiles;
		} catch (SQLException e){
			throw e;
		}
	}

	public void updatePlantProfile(PlantProfile plantProfile) throws SQLException{
		// TODO Auto-generated method stub
		try{
			db.update(Queries.UPDATE_PLANT_PROFILE, plantProfile.getName(),
					plantProfile.getCo2Boundaries().getMin(), plantProfile.getCo2Boundaries().getMax(),
					plantProfile.getTemperatureBoundaries().getMin(),plantProfile.getTemperatureBoundaries().getMax(),
					plantProfile.getHumidityBoundaries().getMin(), plantProfile.getHumidityBoundaries().getMax(),
					plantProfile.getLightBoundaries().getMin(), plantProfile.getLightBoundaries().getMax(), plantProfile.getId());
		}catch (SQLException e){
			throw e;
		}
	}

	public void deletePlantProfile(int plantProfileID) throws SQLException{
		try{
			db.update(Queries.DELETE_PLANT_PROFILE,plantProfileID);
		}
		catch (SQLException e ){
			throw e;
		}
		
	}

	// TODO: This can be moved to PlantProfileDao
	private void initializeSensorBoundaries(Object[] row) {
		SensorBoundaries co2 = new SensorBoundaries(
				Double.parseDouble(row[5].toString()),
				Double.parseDouble(row[4].toString())
		);

		SensorBoundaries humidity = new SensorBoundaries(
				Double.parseDouble(row[7].toString()),
				Double.parseDouble(row[6].toString())
		);

		SensorBoundaries temperature = new SensorBoundaries(
				Double.parseDouble(row[9].toString()),
				Double.parseDouble(row[8].toString())
		);

		SensorBoundaries light = new SensorBoundaries(
				Double.parseDouble(row[10].toString()),
				Double.parseDouble(row[11].toString())
		);
	}

	public PlantProfile getPlantProfileById(int profileId) throws SQLException{
		return null;
	}
}
