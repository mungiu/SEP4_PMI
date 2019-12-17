package dao;

import model.PlantData;
import utils.Database;
import utils.exceptions.PlantNotFoundException;
import utils.queries.PlantDataQueries;
import utils.queries.PlantQueries;

import java.sql.SQLException;
import java.util.ArrayList;

public class PlantDataDao {

    Database db;

    public PlantDataDao(){
        db = Database.getInstance();
    }

    public void addPlantDatas(PlantData[] datas) throws SQLException {
        for (PlantData data:datas) {
            db.update(PlantDataQueries.CREATE_PLANT_DATA, data.getId(), data.getSensorDataType().getValue(), data.getMeasurementValue(), data.getMeasurementTimestamp());
        }
    }

    public int getPlantIdByDeviceId(String deviceId) throws SQLException, PlantNotFoundException {
        ArrayList<Object[]> result = db.query(PlantQueries.GET_PLANT_ID_BY_DEVICE_ID, deviceId);
        int plantId = -1;
        if(result.size()>=1){
            plantId = Integer.parseInt(result.get(0)[0].toString());
        }
        if (plantId == -1){
            throw new PlantNotFoundException();
        }
        return plantId;
    }

}
