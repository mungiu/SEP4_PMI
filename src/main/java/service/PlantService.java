package service;

import dao.PlantDao;
import model.domain.IPlant;

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
    public IPlant getPlantById(int plantID) throws SQLException {
        return dao.getPlantById(plantID);
    }

    /**
     * todo
     */
    public void createPlant(IPlant plant) throws SQLException {
    	if(isValid(plant))
        {
            dao.createPlant(plant);
        }
    }

    /**
     * todo
     */
    @Override
    public void updatePlant(IPlant plant) throws SQLException {
    	if(isValid(plant))
    	{
            dao.updatePlant(plant);
        }
    }

    /**
     * todo
     */
    @Override
    public void deletePlant(int plantID) throws SQLException {
    	dao.deletePlant(plantID);
    }

    private boolean isValid(IPlant plant){
        return plant != null && plant.getDeviceId() != null && plant.getDeviceId().trim().length() != 0
                && plant.getPlantName() != null && plant.getPlantName().trim().length() != 0
                && plant.getPlantProfileId() != 0;
    }


}




