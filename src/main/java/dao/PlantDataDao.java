package dao;

import model.PlantData;
import utils.Database;

public class PlantDataDao {

    Database db;

    public PlantDataDao(){
        db = Database.getInstance();
    }

    public void addPlantDatas(PlantData[] datas, String deviceId) {

    }

}
