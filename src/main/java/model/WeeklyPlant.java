package model;

import model.domain.Plant;

public class WeeklyPlant  {
    private PlantData[] co2;
    private PlantData[] humidity;
    private PlantData[] temperature;
    private PlantData[] light;

    public WeeklyPlant(){

    }

    public WeeklyPlant(PlantData[] co2,PlantData[] humidity, PlantData[] temperature, PlantData[] light ){
        this.co2 = co2;
        this.humidity = humidity;
        this.temperature = temperature;
        this.light = light;
    }

    public PlantData[] getCo2() {
        return co2;
    }

    public void setCo2(PlantData[] co2) {
        this.co2 = co2;
    }

    public PlantData[] getHumidity() {
        return humidity;
    }

    public void setHumidity(PlantData[] humidity) {
        this.humidity = humidity;
    }

    public PlantData[] getTemperature() {
        return temperature;
    }

    public void setTemperature(PlantData[] temperature) {
        this.temperature = temperature;
    }

    public PlantData[] getLight() {
        return light;
    }

    public void setLight(PlantData[] light) {
        this.light = light;
    }
}
