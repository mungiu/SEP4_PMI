package service;

import model.PlantProfile;
import model.PlantProfileList;
import utils.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dao.PlantProfileDao;

public class PlantProfileService implements IPlantProfileService {

	private PlantProfileDao dao;
	
	public PlantProfileService() {
		dao = PlantProfileDao.getInstance();
	}
	
	@Override
	public PlantProfileList getAllPlantProfiles(String userId) throws SQLException {
		return dao.getPlantProfiles(userId);
	}


	@Override
	public void createPlantProfile(PlantProfile plantProfile) throws SQLException {
		dao.createPlantProfile(plantProfile);
	}

	
	@Override
	public void updatePlantProfile(PlantProfile plantProfile) throws SQLException {
		dao.updatePlantProfile(plantProfile);
	}

	
	@Override
	public void deletePlantProfile(String plantProfileID) throws SQLException {
		dao.deletePlantProfile(plantProfileID);
	}

	
}
