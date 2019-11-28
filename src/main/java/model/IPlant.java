package model;

public interface IPlant {

    int getPlantId();

    String getDeviceId();

    void setDeviceId(String deviceId);

    String getPlantName();

    void setPlantName(String plantName);

    IPlantProfile getPlantProfile();

    void setPlantProfile(IPlantProfile plantProfile);

    PlantData getCo2();

    void setCo2(PlantData data);

    PlantData getTemperature();

    void setTemperature(PlantData data);

    void setLight(PlantData data);

    void setHumidity(PlantData data);

    PlantData getHumidity();

    PlantData getLight();

}


