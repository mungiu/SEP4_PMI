package utils;

public class Queries {

	public static final String GET_PLANTS_BY_USER_ID = "SELECT p.Plant_ID, p.Profile_ID, p.PlantName,\n" +
			"       PP.Profile_Name, PP.CO2_Max, PP.CO2_Min,\n" +
			"       PP.Hum_Max, PP.Hum_Min,\n" +
			"       PP.Tem_Max, PP.Tem_Min,\n" +
			"       PP.Light_Max, PP.Light_Min,\n" +
			"       PP.User_ID \n" +
			//"       PD.ID, PD.Sensor_Type, PD.Sensor_Value, PD.TimeStamp\n" +
			//"from dbo.Plant p left join dbo.PlantData PD on p.Plant_ID = PD.Plant_ID\n" +
			"from SEP4_PMI.dbo.Plant p left join SEP4_PMI.dbo.PlantProfile PP on p.Profile_ID = PP.Profile_ID\n" +
			"WHERE User_ID = ?;";

	public static final String GET_PLANT_DATA_BY_TYPE_AND_PLANT_ID = "select top 1 PD.Data_ID, PD.sensor_type, PD.sensor_value, PD.timestamp from SEP4_PMI.dbo.PlantData PD where PD.Sensor_Type = ? AND PD.Plant_ID = ? ORDER BY PD.TimeStamp DESC;";
	public static final String CREATE_PLANT = "insert into dbo.Plant(Plant_ID ,Profile_ID, PlantName) values (?,?,?);";
	public static final String UPDATE_PLANT = "update dbo.Plant set Plant_ID = ?, Profile_ID = ?, PlantName = ? where Plant_ID = ?;";
	public static final String DELETE_PLANT = "delete from dbo.Plant where Plant_ID = ?;";

	public static final String GET_PLANT_PROFILES = "select PP.Profile_Id, PP.Profile_Name, "+
			"PP.CO2_Max, PP.CO2_Min, "+
			"PP.Hum_Max, PP.Hum_Min, "+
			"PP.Tem_Max, PP.Tem_Min, "+
			"PP.Light_Max, PP.Light_Min "+
			"from SEP4_PMI.dbo.PlantProfile PP where user_ID = ?;";
	public static final String CREATE_PLANT_PROFILE = "insert into dbo.PlantProfile (User_ID, Profile_Name, CO2_Max, CO2_Min, Hum_Max, Hum_Min, Tem_Max, Tem_Min, Light_Max, Light_Min) values (?,?,?,?,?,?,?,?,?,?);";
	public static final String UPDATE_PLANT_PROFILE = "update dbo.PlantProfile set User_ID = ?, Profile_Name = ?, CO2_Max = ?, CO2_Min = ?, Hum_Max = ?, Hum_Min = ?, Tem_Max = ?, Tem_Min = ?, Light_Max = ?, Light_Min = ? where Profile_ID = ?;";
	public static final String DELETE_PLANT_PROFILE = "delete from dbo.PlantProfile where Profile_ID = ?;";

	public static final String GET_USER = "select * from dbo.Users where User_ID = ?;";
	public static final String CREATE_USER = "insert into dbo.Users(User_ID, Password) values (?,?);";
	public static final String UPDATE_USER = "update dbo.Users set User_ID = ?, Password = ? where User_ID = ?;";
	public static final String DELETE_USER = "delete from dbo.Users where User_ID = ?;";

	public static final String GET_PLANTINFO = "select * from dbo.PlantInfo where ID = ?;";
	public static final String CREATE_PLANTINFO = "insert into dbo.PlantInfo(Plant_ID, Sensor_Type, Sensor_Value, TimeStamp) values (?,?,?,?);";/*CURRENT_TIMESTAMP instead of the last ? If you want the stamp from the Microsoft SQL server. Else retreive before on java server or device.*/
	public static final String UPDATE_PLANTINFO = "update dbo.PlantInfo set ID = ?, Plant_ID = ?, Sensor_Type  = ?, Sensor_Value = ?, TimeStamp = ? where Plant_ID = ?;";
	public static final String DELETE_PLANTINFO = "delete from dbo.PlantInfo where ID = ?;";
	public static final String GET_PLANT_BY_ID = "select * from dbo.PlantProfile where Profile_ID = ?;";

}
