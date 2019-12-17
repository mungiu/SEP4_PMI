package service;

import model.PlantData;
import model.SensorDataTypes;
import dao.PlantDataDao;
import org.json.JSONObject;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class PlantDataService implements IPlantDataService {

    @Override
    public PlantData[] serializePlantDataFromJSON(CharSequence data) throws ParseException {
        // TODO: This could be extracted as a single CONST which is used all over the application
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        JSONObject jsonObject = new JSONObject(data.toString());
        String timestamp = jsonObject.opt("ts").toString();
        String deviceId = jsonObject.opt("EUI").toString();
        String hexString = jsonObject.opt("data").toString();

        if (timestamp != null && deviceId != null && hexString != null) {
            Date date = dateFormat.parse(timestamp);
            int plantId = new PlantDataDao().getPlantIdByDeviceId(deviceId);
            int humidity = Integer.parseInt(hexString.substring(0, 4), 16);
            int temperature = Integer.parseInt(hexString.substring(4, 8), 16);
            int co2 = Integer.parseInt(hexString.substring(8, 12), 16);
            int light = Integer.parseInt(hexString.substring(12, 14), 16);
            int status = Integer.parseInt(hexString.substring(14, 16), 16);

            return initializePlantDataObjects(humidity, temperature, co2, light, date, plantId);
        } else {
            return null;
        }

    }

    private PlantData[] initializePlantDataObjects(int humidity, int temperature, int co2, int light, Date date, int plantId) {
        PlantData[] plantDataArray = new PlantData[4];

        plantDataArray[0] = new PlantData(humidity, SensorDataTypes.HUMIDITY, plantId, date);
        plantDataArray[1] = new PlantData(temperature, SensorDataTypes.HUMIDITY, plantId, date);
        plantDataArray[2] = new PlantData(co2, SensorDataTypes.HUMIDITY, plantId, date);
        plantDataArray[3] = new PlantData(light, SensorDataTypes.HUMIDITY, plantId, date);

        return plantDataArray;
    }
}
