package dao;

import model.*;
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


    public void createPlant(IPlant plant) throws SQLException {
        try {
            db.update(Queries.CREATE_PLANT, plant.getProfile().getId(), plant.getName());

        } catch (SQLException e) {
            throw e;
        }

    }

    /**
     * Deletes a plant from the database
     *
     * @param plantID
     */

    public void deletePlant(String plantID) throws SQLException {
        try {
            db.update(Queries.DELETE_PLANT, plantID);
        } catch (SQLException e) {
            throw e;
        }
    }

    public void updatePlant(IPlant plant) throws SQLException {
        try {
            //update SEP4_PMI.Plant set Plant_ID = ?, Profile_ID = ?, PlantName = ? where Plant_ID = ?;
            db.update(Queries.UPDATE_PLANT, plant.getId(), plant.getProfile().getId(), plant.getName(), plant.getId());
        } catch (SQLException e) {
            throw e;
        }
    }

    public PlantList getPlants(String userId) throws SQLException , ParseException{
        try {
            ArrayList<Object[]> queryResult = db.query(Queries.GET_PLANTS_BY_USER_ID, userId);
            PlantList plantList = new PlantList();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            for (Object[] row : queryResult) {
				/*public static final String GET_PLANTS_BY_USER_ID = "SELECT p.Plant_ID, p.Profile_ID, p.PlantName,\n" +
			"       PP.Profile_Name, PP.CO2_Max, PP.CO2_Min,\n" +
			"       PP.Hum_Max, PP.Hum_Min,\n" +
			"       PP.Tem_Max, PP.Tem_Min,\n" +
			"       PP.Light_Max, PP.Light_Min,\n" +
			"       PP.User_ID,\n" +
			"       PD.ID, PD.Sensor_Type, PD.Sensor_Value, PD.TimeStamp\n" +
			"from dbo.Plant p left join dbo.PlantData PD on p.Plant_ID = PD.Plant_ID\n" +
			"left join dbo.PlantProfile PP on p.Profile_ID = PP.Profile_ID\n" +
			"WHERE User_ID = ?;";	*/
                int plantId = Integer.parseInt(row[0].toString());
                int profileId = Integer.parseInt(row[1].toString());
                String plantName = row[2].toString();
                String profileName = row[3].toString();
                double co2Max = Double.parseDouble(row[4].toString());
                double co2Min = Double.parseDouble(row[5].toString());
                double humidityMax = Double.parseDouble(row[6].toString());
                double humidityMin = Double.parseDouble(row[7].toString());
                double temperatureMax = Double.parseDouble(row[8].toString());
                double temperatureMin = Double.parseDouble(row[9].toString());
                double lightMax = Double.parseDouble(row[10].toString());
                double lightMin = Double.parseDouble(row[11].toString());
                String userID = row[12].toString();
                IUser user = new User();
                user.setEmail(userID);
                SensorBoundaries co2 = new SensorBoundaries(co2Min, co2Max);
                SensorBoundaries humidity = new SensorBoundaries(humidityMin, humidityMax);
                SensorBoundaries temperature = new SensorBoundaries(temperatureMin, temperatureMax);
                SensorBoundaries light = new SensorBoundaries(lightMin, lightMax);
                IPlantProfile profile = new PlantProfile(profileId, profileName, user, co2, temperature, humidity, light);
                String[] dataTypes = {"CO2", "Humidity", "Temperature", "Light"};
                PlantData[] plantDatas = new PlantData[4];
                for (int i = 0; i < 4; i++) {
                    //"select top 1 PD.id, PD.sensor_type, PD.sensor_value, PD.timestamp from PlantData PD where PD.Sensor_Type = ? AND PD.Plant_ID = ? ORDER BY PD.TimeStamp DESC;";
                    ArrayList<Object[]> dataTable = db.query(Queries.GET_PLANT_DATA_BY_TYPE_AND_PLANT_ID, dataTypes[i], plantId);
                    if (dataTable.size() >= 1) {
                        Object[] dataRow = dataTable.get(0);
                        int dataId = Integer.parseInt(dataRow[0].toString());
                        String sensorType = dataRow[1].toString();
                        double sensorValue = Double.parseDouble(dataRow[2].toString());
                        Date timestamp = dateFormat.parse(dataRow[3].toString());
                        plantDatas[i] = new PlantData(dataId, sensorValue, sensorType, plantId, timestamp);
                    }
                    else {
                    	plantDatas[i] = new PlantData();
                    	plantDatas[i].setType(dataTypes[i]);
					}
                }
                IPlant plant = new Plant(plantId, plantName, profile, plantDatas[0], plantDatas[2], plantDatas[1], plantDatas[3]);
                plantList.addPlant(plant);
            }
            return plantList;
        } catch (SQLException e) {
            throw e;
        } catch (ParseException e) {
            throw e;
        }
    }

    public IPlant getPlantById(String plantID) {
        //todo
        return null;
    }
}
