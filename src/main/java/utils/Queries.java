package utils;

public class Queries {
	public static final String CREATE_PLANT = "insert into dao.Plant(Profile_ID, PlantName) values (?,?);";
	public static final String CREATE_PLANT_PROFILE = "insert into dao.PlantProfile (User_ID, Profile_Name, CO2_Max, CO2_Min, Hum_Max, Hum_Min, "
			+ "Tem_Max, Tem_Min, Light_Max, Light_Min) values (?,?,?,?,?,?,?,?,?,?)";
}
