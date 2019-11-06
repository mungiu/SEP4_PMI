package model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import service.IUserService;

import javax.swing.text.PlainDocument;
import java.sql.ResultSet;
import java.sql.SQLException;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "clientType")

public class Plant {


    private int id;
  private String name;
  private PlantInfo humidity, light, co2, temperature;


    public Plant() {

    }

    public Plant(int id) {
       this.id=id;
    }
    public Plant(int id, String name, PlantInfo humidity, PlantInfo light, PlantInfo co2, PlantInfo temperature) {
        this.id = id;
        this.name = name;
        this.humidity = humidity;
        this.light = light;
        this.co2 = co2;
        this.temperature = temperature;
    }


    public Plant populateFromResultSet(ResultSet resultSet, IUserService addressService) throws SQLException {
        Plant plant = new Plant(
                resultSet.getInt("id")
        );

        return plant;
    }

    public int getId() {
        return id;
    }

    public void setId(int  id) {
        this.id = id;
    }

    public String name() {
        return name;
    }

    public void setName(String passwordHash) {
        this.name = name;
    }
    public void setHumidity(PlantInfo humidity){
        this.humidity=humidity;

    }
    public PlantInfo getHumidity(){
        return humidity;
    }
    public void setLight(PlantInfo light){
        this.light=light;
    }

    public PlantInfo getLight(){return  light;}

    public void setCo2(PlantInfo co2){
        this.co2=co2;
    }
    public PlantInfo getCo2(){
        return  co2;
    }
    public  void setTemperature(PlantInfo temperature){
        this.temperature=temperature;
    }

    public PlantInfo getTemperature() {
         return  temperature;
    }
}