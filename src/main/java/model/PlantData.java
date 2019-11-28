package model;

import java.util.Date;

public class PlantData {
	private int id;
	private int plantId;
	private double measurementValue;
	private SensorDataTypes sensorDataType;
	private Date measurementTimestamp;

	public PlantData() { }

	public PlantData(int id, double measurementValue, SensorDataTypes sensorDataType, int plantId, Date measurementTimestamp) {
		this.id = id;
		this.measurementValue = measurementValue;
		this.sensorDataType = sensorDataType;
		this.plantId = plantId;
		this.measurementTimestamp = measurementTimestamp;
	}

    public PlantData(double measurementValue, SensorDataTypes sensorDataType, int plantId, Date measurementTimestamp) {
        this.measurementValue = measurementValue;
        this.sensorDataType = sensorDataType;
        this.plantId = plantId;
        this.measurementTimestamp = measurementTimestamp;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getMeasurementValue() {
		return measurementValue;
	}

	public void setMeasurementValue(double measurementValue) {
		this.measurementValue = measurementValue;
	}

	public SensorDataTypes getSensorDataType() {
		return sensorDataType;
	}

	public void setSensorDataType(SensorDataTypes sensorDataType) {
		this.sensorDataType = sensorDataType;
	}

	public int getPlantId() {
		return plantId;
	}

	public void setPlantId(int plantId) {
		this.plantId = plantId;
	}

	public Date getMeasurementTimestamp() {
		return measurementTimestamp;
	}

	public void setMeasurementTimestamp(Date measurementTimestamp) {
		this.measurementTimestamp = measurementTimestamp;
	}
}
