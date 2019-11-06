package model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class PlantProfile {
private int id;
    private String name;
    private SensorBoundaries co2, temperature, humidity, light;


    public PlantProfile() {


    }
    public PlantProfile(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SensorBoundaries getCo2() {
        return co2;
    }

    public void setCo2(SensorBoundaries co2) {
        this.co2 = co2;
    }

    public SensorBoundaries getTemperature() {
        return temperature;
    }

    public void setTemperature(SensorBoundaries temperature) {
        this.temperature = temperature;
    }

    public SensorBoundaries getHumidity() {
        return humidity;
    }

    public void setHumidity(SensorBoundaries humidity) {
        this.humidity = humidity;
    }

    public SensorBoundaries getLight() {
        return light;
    }

    public void setLight(SensorBoundaries light) {
        this.light = light;
    }



}