package model.domain;

import model.SensorBoundaries;

public interface IPlantProfile {

    int getId();

    String getName();

    void setName(String name);

    void setUserEmail(String userEmail);

    String getUserEmail();

    void setCo2Boundaries(SensorBoundaries boundaries);

    SensorBoundaries getCo2Boundaries();

    void setTemperatureBoundaries(SensorBoundaries boundaries);

    SensorBoundaries getTemperatureBoundaries();

    void setHumidityBoundaries(SensorBoundaries boundaries);

    SensorBoundaries getHumidityBoundaries();

    void setLightBoundaries(SensorBoundaries bondaries);

    SensorBoundaries getLightBoundaries();

    void setId(int id);
}