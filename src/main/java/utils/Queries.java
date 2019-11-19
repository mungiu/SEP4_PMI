package utils;

public class Queries {

	public static final String GET_PLANTS /*suggestion - refactor String name to be mere explicit: ..._BY_USER*/= "select Plant_ID, p.Profile_ID , PlantName from dao.Plant p join dao.PlantProfile pp on p.Profile_ID = pp.Profile_ID where User_ID = ?;";
	public static final String CREATE_PLANT = "insert into dao.Plant(Profile_ID, PlantName) values (?,?);";
	public static final String UPDATE_PLANT = "update dao.Plant set Plant_ID = ?, Profile_ID = ?, PlantName = ? where Plant_ID = ?;";
	public static final String DELETE_PLANT = "delete from dao.Plant where Plant_ID = ?;";

	public static final String GET_PLANT_PROFILES /*suggestion - refactor String name to be mere explicit: ..._BY_USER*/= "select * from dao.PlantProfile where user_ID = ?;";
	public static final String CREATE_PLANT_PROFILE = "insert into dao.PlantProfile (User_ID, Profile_Name, CO2_Max, CO2_Min, Hum_Max, Hum_Min, Tem_Max, Tem_Min, Light_Max, Light_Min) values (?,?,?,?,?,?,?,?,?,?);";
	public static final String UPDATE_PLANT_PROFILE = "update dao.PlantProfile set User_ID = ?, Profile_Name = ?, CO2_Max = ?, CO2_Min = ?, Hum_Max = ?, Hum_Min = ?, Tem_Max = ?, Tem_Min = ?, Light_Max = ?, Light_Min = ? where Profile_ID = ?;";
	public static final String DELETE_PLANT_PROFILE = "delete from dao.PlantProfile where Profile_ID = ?;";

	public static final String GET_USER = "select * from dao.Users where User_ID = ?;";
	public static final String CREATE_USER = "insert into dao.Users(User_ID, Password) values (?,?);";
	public static final String UPDATE_USER = "update dao.Users set User_ID = ?, Password = ? where User_ID = ?;";
	public static final String DELETE_USER = "delete from dao.Users where User_ID = ?;";

	public static final String GET_PLANTINFO = "select * from dao.PlantInfo where ID = ?;";
	public static final String CREATE_PLANTINFO = "insert into dao.PlantInfo(Plant_ID, Sensor_Type, Sensor_Value, TimeStamp) values (?,?,?,?);";/*CURRENT_TIMESTAMP instead of the last ? If you want the stamp from the Microsoft SQL server. Else retreive before on java server or device.*/
	public static final String UPDATE_PLANTINFO = "update dao.PlantInfo set ID = ?, Plant_ID = ?, Sensor_Type  = ?, Sensor_Value = ?, TimeStamp = ? where Plant_ID = ?;";
	public static final String DELETE_PLANTINFO = "delete from dao.PlantInfo where ID = ?;";

}
