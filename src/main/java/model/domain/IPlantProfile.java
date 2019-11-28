package model.domain;

import model.SensorBoundaries;

public interface IPlantProfile {

    int getId();

    String getName();

    void setName(String name);

    void setUserEmail(String userEmail);

    String getUserEmail();

    void setCo2(SensorBoundaries boundaries);

    SensorBoundaries getCo2();

    void setTemperature(SensorBoundaries boundaries);

    SensorBoundaries getTemperature();

    void setHumidity(SensorBoundaries boundaries);

    SensorBoundaries getHumidity();

    void setLight(SensorBoundaries bondaries);

    SensorBoundaries getLight();

    void setId(int id);
}