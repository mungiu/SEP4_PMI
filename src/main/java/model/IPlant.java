package model;

public interface IPlant {

    int getId();

    void setId(int id);

    String getName();

    void setName(String name);

    IPlantProfile getProfile();

    void setProfile(IPlantProfile plantProfile);

    PlantData getCo2();

    void setCo2(PlantData data);

    PlantData getTemperature();

    void setTemperature(PlantData data);

    void setLight(PlantData data);

    void setHumidity(PlantData data);

    PlantData getHumidity();

    PlantData getLight();

}


