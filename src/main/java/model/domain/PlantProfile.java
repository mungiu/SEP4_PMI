package model.domain;

import model.SensorBoundaries;

public class PlantProfile implements IPlantProfile {
	private int id;
	private String name;
	private String userEmail;
	private SensorBoundaries co2Boundaries, temperatureBoundaries, humidityBoundaries, lightBoundaries;

	public PlantProfile() {
	}

	public PlantProfile(int id, String name, String userEmail, SensorBoundaries co2Boundaries, SensorBoundaries temperatureBoundaries,
						SensorBoundaries humidityBoundaries, SensorBoundaries lightBoundaries) {
		this.id = id;
		this.name = name;
		this.userEmail = userEmail;
		this.co2Boundaries = co2Boundaries;
		this.temperatureBoundaries = temperatureBoundaries;
		this.humidityBoundaries = humidityBoundaries;
		this.lightBoundaries = lightBoundaries;
	}

	public PlantProfile(String name, String userEmail, SensorBoundaries co2Boundaries, SensorBoundaries temperatureBoundaries,
						SensorBoundaries humidityBoundaries, SensorBoundaries lightBoundaries) {
		this.name = name;
		this.userEmail = userEmail;
		this.co2Boundaries = co2Boundaries;
		this.temperatureBoundaries = temperatureBoundaries;
		this.humidityBoundaries = humidityBoundaries;
		this.lightBoundaries = lightBoundaries;
	}

	@Override
	public int getId() {
		return id;
	}

	// TODO: We should never set id manually as it's generated by the database.
    @Override
    public void setId(int id) {
		this.id = id;
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
	public String getUserEmail() {
		return userEmail;
	}

	@Override
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	@Override
	public SensorBoundaries getCo2Boundaries() {
		return co2Boundaries;
	}

	@Override
	public void setCo2Boundaries(SensorBoundaries co2Boundaries) {
		this.co2Boundaries = co2Boundaries;
	}

	@Override
	public SensorBoundaries getTemperatureBoundaries() {
		return temperatureBoundaries;
	}

	@Override
	public void setTemperatureBoundaries(SensorBoundaries temperatureBoundaries) {
		this.temperatureBoundaries = temperatureBoundaries;
	}

	@Override
	public SensorBoundaries getHumidityBoundaries() {
		return humidityBoundaries;
	}

	@Override
	public void setHumidityBoundaries(SensorBoundaries humidityBoundaries) {
		this.humidityBoundaries = humidityBoundaries;
	}

	@Override
	public SensorBoundaries getLightBoundaries() {
		return lightBoundaries;
	}

	@Override
    public void setLightBoundaries(SensorBoundaries lightBoundaries) {
		this.lightBoundaries = lightBoundaries;
	}

}