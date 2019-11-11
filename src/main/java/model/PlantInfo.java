package model;

import java.time.LocalDateTime;
import java.util.Date;

public class PlantInfo {
    private int id;
    private double value;
    private String name;
    private int plantId;
    private Date dateTime;

    public PlantInfo(int id) {
        this.id = id;
    }

    public PlantInfo(int id, double value, String name, int plantId, Date dateTime) {
        this.id = id;
        this.value = value;
        this.name = name;
        this.plantId = plantId;
        this.dateTime = dateTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPlantId() {
        return plantId;
    }

    public void setPlantId(int plantId) {
        this.plantId = plantId;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }
}
