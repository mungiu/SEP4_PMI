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
	private PlantProfile profile;

	public Plant() {

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

	public PlantProfile getProfile() {
		return profile;
	}

	public void setProfile(PlantProfile profile) {
		this.profile = profile;
	}

}