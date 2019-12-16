package dao;

import model.*;
import model.domain.IPlant;
import model.domain.Plant;
import model.PlantList;
import utils.Database;
import utils.queries.PlantDataQueries;
import utils.queries.PlantQueries;
import utils.queries.WeeklyPlantQueries;

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
        db.update(PlantQueries.CREATE_PLANT, plant.getDeviceId(), plant.getPlantProfileId(), plant.getPlantName());
    }

    /**
     * Deletes a plant from the database
     *
     * @param plantID
     */

    public void deletePlant(int plantID) throws SQLException {
        db.update(PlantQueries.DELETE_PLANT, plantID);
    }

    /**
     * Update a plant in the database
     *
     * @param plant
     */
    public void updatePlant(IPlant plant) throws SQLException {
        db.update(PlantQueries.UPDATE_PLANT, plant.getDeviceId(), plant.getPlantProfileId(), plant.getPlantName(), plant.getPlantId());
    }

    /**
     * Get all plants from the database
     */
    public PlantList getPlants(String userEmail) throws SQLException {
            ArrayList<Object[]> queryResults = db.query(PlantQueries.GET_PLANTS_BY_USER_ID, userEmail);
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
                {SensorDataTypes.CO2, SensorDataTypes.HUMIDITY, SensorDataTypes.TEMPERATURE, SensorDataTypes.LIGHT};

        PlantData[] plantData = new PlantData[4];

        for (int i = 0; i < 4; i++) {
            ArrayList<Object[]> results = db.query(PlantDataQueries.GET_PLANT_DATA_BY_TYPE_AND_PLANT_ID, typesInOrder[i].getValue(), plantId);

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
        //p.Plant_ID, p.Profile_ID, p.PlantName, p.Device_ID
        int plantId = Integer.parseInt(row[0].toString());
        int plantProfileId = Integer.parseInt(row[1].toString());
        String plantName = row[2].toString();
        String deviceID = row[3].toString();
        PlantData[] plantData = getLatestPlantData(plantId);

        return new Plant(plantId, deviceID, plantName, plantProfileId, plantData[0], plantData[2], plantData[1], plantData[3]);
    }

    private PlantData initializePlantData(Object[] lastRecord, int plantId) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        int plantDataId = Integer.parseInt(lastRecord[0].toString());
        SensorDataTypes sensorDataType = SensorDataTypes.valueOf(lastRecord[1].toString().toUpperCase());
        double sensorMeasurementValue = Double.parseDouble(lastRecord[2].toString());
        Date recordTimestamp = dateFormat.parse(lastRecord[3].toString());

        return new PlantData(plantDataId, sensorMeasurementValue, sensorDataType, plantId, recordTimestamp);
    }

    public WeeklyPlant getWeeklyPlantAvg(int plantID) throws SQLException {
        PlantData[] co2 = getWeeklyCo2OfPlant(plantID);
        PlantData[] humidity = getWeeklyHumidityOfPlant(plantID);
        PlantData[] temperature = getWeeklyTemperatureOfPlant(plantID);
        PlantData[] light = getWeeklyLightOfPlant(plantID);
        WeeklyPlant weeklyPlant = new WeeklyPlant(co2,humidity,temperature,light);
        return weeklyPlant;
    }

    private PlantData[] getWeeklyCo2OfPlant(int plantId) throws SQLException {
        ArrayList<Object[]> result = db.query(WeeklyPlantQueries.GET_WEEKLY_CO2_AVG_OF_PLANT, plantId);
        return initializeWeeklyPlantData(SensorDataTypes.CO2, result, plantId);
    }

    private PlantData[] getWeeklyHumidityOfPlant(int plantId) throws SQLException {
        ArrayList<Object[]> result = db.query(WeeklyPlantQueries.GET_WEEKLY_HUMIDITY_AVG_OF_PLANT, plantId);
        return initializeWeeklyPlantData(SensorDataTypes.HUMIDITY, result, plantId);
    }

    private PlantData[] getWeeklyTemperatureOfPlant(int plantId) throws SQLException{
        ArrayList<Object[]> result = db.query(WeeklyPlantQueries.GET_WEEKLY_TEMPERATURE_AVG_OF_PLANT, plantId);
        return initializeWeeklyPlantData(SensorDataTypes.TEMPERATURE, result, plantId);
    }

    private PlantData[] getWeeklyLightOfPlant(int plantId) throws SQLException{
        ArrayList<Object[]> result = db.query(WeeklyPlantQueries.GET_WEEKLY_LIGHT_AVG_OF_PLANT, plantId);
        return initializeWeeklyPlantData(SensorDataTypes.LIGHT, result, plantId);
    }

    private PlantData[] initializeWeeklyPlantData(SensorDataTypes type, ArrayList<Object[]> result, int plantId)  {
        PlantData[] datas = new PlantData[7];
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        for(int i = 0; i < result.size() && i < 7; i++){
            Date recordTimestamp = null;
            try {
                recordTimestamp = dateFormat.parse(result.get(i)[0].toString());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            double sensorMeasurementValue = Double.parseDouble(result.get(i)[1].toString());

            PlantData data = new PlantData(sensorMeasurementValue,type,plantId,recordTimestamp);
            datas[i] = data;
        }
        return datas;
    }
}
