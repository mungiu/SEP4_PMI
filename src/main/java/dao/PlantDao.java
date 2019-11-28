package dao;

import model.*;
import model.domain.IPlant;
import model.domain.Plant;
import model.PlantList;
import utils.Database;
import utils.Queries;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class PlantDao {
    private Database db;

    public PlantDao() {
        db = Database.getInstance();
    }

    /**
     * Create a plant
     *
     * @param
     */

    public void createPlant(IPlant plant) throws SQLException {
        db.update(Queries.CREATE_PLANT, plant.getPlantProfileId(), plant.getDeviceId(), plant.getPlantName());
    }

    /**
     * Deletes a plant from the database
     *
     * @param plantID
     */

    public void deletePlant(String plantID) throws SQLException {
        db.update(Queries.DELETE_PLANT, plantID);
    }

    /**
     * Update a plant in the database
     *
     * @param plant
     */
    public void updatePlant(IPlant plant) throws SQLException {
        db.update(Queries.UPDATE_PLANT, plant.getDeviceId(), plant.getPlantProfileId(), plant.getPlantName(), plant.getDeviceId());
    }

    /**
     * Get all plants from the database
     */
    public PlantList getPlants(String userEmail) throws SQLException {
            ArrayList<Object[]> queryResults = db.query(Queries.GET_PLANTS_BY_USER_ID, userEmail);
            PlantList plantList = new PlantList();

        try {
            for (Object[] row : queryResults) {
                IPlant plant = initializePlant(row);
                plantList.addPlant(plant);
            }
        } catch (ParseException e) {
            // TODO:
        }

        return plantList;
    }

    /**
     * Get latest measurements from the database
     */
    private PlantData[] getLatestPlantData(int plantId) throws SQLException, ParseException {
        SensorDataTypes[] typesInOrder =
                {SensorDataTypes.CO2, SensorDataTypes.HUM, SensorDataTypes.TEMP, SensorDataTypes.LIGHT};

        PlantData[] plantData = new PlantData[4];

        for (int i = 0; i < 4; i++) {
            ArrayList<Object[]> results = db.query(Queries.GET_PLANT_DATA_BY_TYPE_AND_PLANT_ID, typesInOrder[i].getValue(), plantId);

            if (!results.isEmpty()) {
                Object[] lastRecord = results.get(0);
                plantData[i] = initializePlantData(lastRecord, plantId);
            } else {
                plantData[i] = new PlantData();
                plantData[i].setSensorDataType(typesInOrder[i]);
            }
        }
        return plantData;
    }

    /**
     *
     * Helper methods -> Might be moved somewhere else
     *
     */

    private IPlant initializePlant(Object[] row) throws SQLException, ParseException {
        int plantId = Integer.parseInt(row[0].toString());
        // Todo: Add String deviceId = row[?].toString(); -> We need to retrieve id from the database
        int plantProfileId = Integer.parseInt(row[1].toString());
        String plantName = row[2].toString();
        PlantData[] plantData = getLatestPlantData(plantId);

        return new Plant(plantId, "todo-device-id", plantName, plantProfileId, plantData[0], plantData[2], plantData[1], plantData[3]);
    }

    private PlantData initializePlantData(Object[] lastRecord, int plantId) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        int plantDataId = Integer.parseInt(lastRecord[0].toString());
        SensorDataTypes sensorDataType = SensorDataTypes.valueOf(lastRecord[1].toString());
        double sensorMeasurementValue = Double.parseDouble(lastRecord[2].toString());
        Date recordTimestamp = dateFormat.parse(lastRecord[3].toString());

        return new PlantData(plantDataId, sensorMeasurementValue, sensorDataType, plantId, recordTimestamp);
    }

    public IPlant getPlantById(String plantID) {
        return null;
    }
}
