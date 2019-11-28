package model;

import java.util.Date;

public class PlantData {
	private int id;
	private double value;
	private SensorDataTypes type;
	private int plantId;
	private Date dateTime;

	public PlantData(int id) {
		this.id = id;
	}

	public PlantData() {

	}

	public PlantData(int id, double value, SensorDataTypes type, int plantId, Date dateTime) {
		this.id = id;
		this.value = value;
		this.type = type;
		this.plantId = plantId;
		this.dateTime = dateTime;
	}

    public PlantData(double value, SensorDataTypes type, int plantId, Date dateTime) {
        this.value = value;
        this.type = type;
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

	public SensorDataTypes getType() {
		return type;
	}

	public void setType(SensorDataTypes type) {
		this.type = type;
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
