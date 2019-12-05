package model.domain;

import model.PlantData;

public interface IPlant {

    int getPlantId();

    String getDeviceId();

    void setDeviceId(String deviceId);

    String getPlantName();

    void setPlantName(String plantName);

    int getPlantProfileId();

    void setPlantProfileId(int plantProfileId);

    PlantData getLastCO2Measurement();

    void setLastCO2Measurement(PlantData data);

    PlantData getLastTemperatureMeasurement();

    void setLastTemperatureMeasurement(PlantData data);

    PlantData getLastHumidityMeasurement();

    void setLastHumidityMeasurement(PlantData data);

    PlantData getLastLightMeasurement();

    void setLastLightMeasurement(PlantData data);
}


