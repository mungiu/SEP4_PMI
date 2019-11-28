package model.domain;

import model.SensorBoundaries;

public class PlantProfile implements IPlantProfile {
	private int id;
	private String name;
	private String userEmail;
	private SensorBoundaries co2, temperature, humidity, light;

	public PlantProfile() {
	}

	public PlantProfile(int id, String name, String userEmail, SensorBoundaries co2, SensorBoundaries temperature,
						SensorBoundaries humidity, SensorBoundaries light) {
		this.id = id;
		this.name = name;
		this.userEmail = userEmail;
		this.co2 = co2;
		this.temperature = temperature;
		this.humidity = humidity;
		this.light = light;
	}

	public PlantProfile(String name, String userEmail, SensorBoundaries co2, SensorBoundaries temperature,
						SensorBoundaries humidity, SensorBoundaries light) {
		this.name = name;
		this.userEmail = userEmail;
		this.co2 = co2;
		this.temperature = temperature;
		this.humidity = humidity;
		this.light = light;
	}

	@Override
	public int getId() {
		return id;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	@Override
	public String getUserEmail() {
		return userEmail;
	}

	@Override
	public SensorBoundaries getCo2() {
		return co2;
	}

	@Override
	public void setCo2(SensorBoundaries co2) {
		this.co2 = co2;
	}

	@Override
	public SensorBoundaries getTemperature() {
		return temperature;
	}

	@Override
	public void setTemperature(SensorBoundaries temperature) {
		this.temperature = temperature;
	}

	@Override
	public SensorBoundaries getHumidity() {
		return humidity;
	}

	@Override
	public void setHumidity(SensorBoundaries humidity) {
		this.humidity = humidity;
	}

	@Override
	public SensorBoundaries getLight() {
		return light;
	}

    @Override
    public void setId(int id) { this.id = id; }

	@Override
    public void setLight(SensorBoundaries light) {
		this.light = light;
	}

}