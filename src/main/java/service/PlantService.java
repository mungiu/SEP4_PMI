package service;

import dao.PlantDao;
import model.IPlant;

import java.sql.SQLException;

public class PlantService implements IPlantService {

    private PlantDao dao;

	public PlantService() {
		dao = new PlantDao();
	}

    /**
     * todo
     * @param plantID
     * @return
     * @throws SQLException
     */
    @Override
    public IPlant getPlantById(String plantID) throws SQLException {
        return dao.getPlantById(plantID);
    }

    /**
     * todo
     */
    public void createPlant(IPlant plant) throws SQLException {
    	dao.createPlant(plant);
    }

    /**
     * todo
     */
    @Override
    public void updatePlant(IPlant plant) throws SQLException {
    	dao.updatePlant(plant);
    }

    /**
     * todo
     */
    @Override
    public void deletePlant(String plantID) throws SQLException {
    	dao.deletePlant(plantID);
    }


}




