package model.domain;

import model.PlantData;

public class Plant implements IPlant {

    private int plantId;
    private String deviceId;
    private int plantProfileId;
    private String plantName;
    private PlantData lastCO2Measurement, lastHumidityMeasurement, lastTemperatureMeasurement, lastLightMeasurement;

    @Override
    public int getPlantId() {
        return plantId;
    }

    @Override
    public String getDeviceId() {
        return deviceId;
    }

    @Override
    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    @Override
    public String getPlantName() {
        return plantName;
    }

    @Override
    public void setPlantName(String plantName) {
        this.plantName = plantName;
    }

    @Override
    public int getPlantProfileId() {
        return plantProfileId;
    }

    @Override
    public void setPlantProfileId(int plantProfileId) {
        this.plantProfileId = plantProfileId;
    }

    @Override
    public PlantData getLastCO2Measurement() {
        return lastCO2Measurement;
    }

    @Override
    public void setLastCO2Measurement(PlantData lastCO2Measurement) {
        this.lastCO2Measurement = lastCO2Measurement;
    }

    @Override
    public PlantData getLastHumidityMeasurement() {
        return lastHumidityMeasurement;
    }

    @Override
    public void setLastHumidityMeasurement(PlantData lastHumidityMeasurement) {
        this.lastHumidityMeasurement = lastHumidityMeasurement;
    }

    @Override
    public PlantData getLastTemperatureMeasurement() {
        return lastTemperatureMeasurement;
    }

    @Override
    public void setLastTemperatureMeasurement(PlantData lastTemperatureMeasurement) {
        this.lastTemperatureMeasurement = lastTemperatureMeasurement;
    }

    @Override
    public PlantData getLastLightMeasurement() {
        return lastLightMeasurement;
    }

    @Override
    public void setLastLightMeasurement(PlantData lastLightMeasurement) {
        this.lastLightMeasurement = lastLightMeasurement;
    }

    public Plant() {
    }

    public Plant(
            int plantId,
            String deviceId,
            String plantName,
            int plantProfileId,
            PlantData lastCO2Measurement,
            PlantData lastTemperatureMeasurement,
            PlantData lastHumidityMeasurement,
            PlantData lastLightMeasurement
    ) {
        this.plantId = plantId;
        this.deviceId = deviceId;
        this.plantName = plantName;
        this.plantProfileId = plantProfileId;
        this.lastCO2Measurement = lastCO2Measurement;
        this.lastTemperatureMeasurement = lastTemperatureMeasurement;
        this.lastHumidityMeasurement = lastHumidityMeasurement;
        this.lastLightMeasurement = lastLightMeasurement;
    }

    public Plant(String deviceId, String plantName, int plantProfileId) {
        this.deviceId = deviceId;
        this.plantName = plantName;
        this.plantProfileId = plantProfileId;
    }
}