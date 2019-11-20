package model;

import service.PlantProfileService;

import java.util.ArrayList;

public class User implements IUser{

	private String email;
	private String password;
	private ArrayList<PlantProfileList> profiles;
	private ArrayList<PlantList> plants;

	public User(String email, String city) {
		profiles = new ArrayList<>();
		plants = new ArrayList<>();
		this.email = email;
		this.password = city;

	}

	public User() {
	}

	public ArrayList<PlantProfileList> getProfiles() {
		return profiles;
	}

	public void setProfiles(ArrayList<PlantProfileList> profiles) {
		this.profiles = profiles;
	}

	public ArrayList<PlantList> getPlants() {
		return plants;
	}

	public void setPlants(ArrayList<PlantList> plants) {
		this.plants = plants;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
