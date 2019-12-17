package service;

import dao.PlantDao;
import model.WeeklyPlant;
import model.domain.IPlant;
import utils.exceptions.MissingDataException;

import java.sql.SQLException;
import java.text.ParseException;

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
    public WeeklyPlant getPlantById(int plantID) throws SQLException {
        return dao.getWeeklyPlantAvg(plantID);
    }

    /**
     * todo
     */
    public void createPlant(IPlant plant) throws SQLException, MissingDataException {
    	if(isValid(plant))
        {
            dao.createPlant(plant);
        }
    	else {
    	    throw new MissingDataException("Please fill out the form");
        }
    }

    /**
     * todo
     */
    @Override
    public void updatePlant(IPlant plant) throws SQLException, MissingDataException {
    	if(isValid(plant))
    	{
            dao.updatePlant(plant);
        }
    	else {
    	    throw new MissingDataException("Please fill out the form");
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




