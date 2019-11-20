package model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import service.IUserService;

import javax.swing.text.PlainDocument;
import java.sql.ResultSet;
import java.sql.SQLException;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "clientType")

public class Plant implements IPlant{

	private int id;
	private String name;
	private IPlantProfile profile;
	private PlantData co2, humidity, temperature, light;

	@Override
	public PlantData getCo2() {
		return co2;
	}

	@Override
	public void setCo2(PlantData co2) {
		this.co2 = co2;
	}

	@Override
	public PlantData getHumidity() {
		return humidity;
	}

	@Override
	public void setHumidity(PlantData humidity) {
		this.humidity = humidity;
	}

	@Override
	public PlantData getTemperature() {
		return temperature;
	}

	@Override
	public void setTemperature(PlantData temperature) {
		this.temperature = temperature;
	}

	@Override
	public PlantData getLight() {
		return light;
	}

	@Override
	public void setLight(PlantData light) {
		this.light = light;
	}

	public Plant() {

	}

	public Plant(int id, String name, PlantProfile profile, PlantData co2, PlantData temperature, PlantData humidity, PlantData light) {
		this.id = id;
		this.name = name;
		this.profile = profile;
		this.co2 = co2;
		this.temperature = temperature;
		this.humidity = humidity;
		this.light = light;
	}

	public Plant(int id, String name, PlantProfile profile) {
		this.id = id;
		this.name = name;
		this.profile = profile;
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

	public IPlantProfile getProfile() {
		return profile;
	}

	public void setProfile(IPlantProfile profile) {
		this.profile = profile;
	}

}