package utils;

public class Queries {

	// TODO: What about splitting this class into 3? PlantQueries, PlantProfileQueries and UserQueries; to keep it
	// nice and clean
	public static final String GET_PLANTS_BY_USER_ID = "SELECT p.Plant_ID, p.Profile_ID, p.PlantName,\n" +
			"PP.Profile_Name, PP.CO2_Max, PP.CO2_Min,\n" +
			"PP.Hum_Max, PP.Hum_Min,\n" +
			"PP.Tem_Max, PP.Tem_Min,\n" +
			"PP.Light_Max, PP.Light_Min,\n" +
			"PP.User_ID \n" +
			"from dbo.Plant p left join dbo.PlantProfile PP on p.Profile_ID = PP.Profile_ID\n" +
			"WHERE User_ID = ?;";

	public static final String GET_PLANT_DATA_BY_TYPE_AND_PLANT_ID = "select top 1 PD.id, PD.sensor_type, PD.sensor_value, PD.timestamp from PlantData PD where PD.Sensor_Type = ? AND PD.Plant_ID = ? ORDER BY PD.TimeStamp DESC;";
	public static final String CREATE_PLANT = "insert into dbo.Plant(Profile_ID, PlantName) values (?,?);";
	public static final String UPDATE_PLANT = "update SEP4_PMI.Plant set Plant_ID = ?, Profile_ID = ?, PlantName = ? where Plant_ID = ?;";
	public static final String DELETE_PLANT = "delete from SEP4_PMI.Plant where Plant_ID = ?;";

	public static final String GET_PLANT_PROFILES = "select PP.Profile_Id, PP.Profile_Name, "+
	"PP.CO2_Max, PP.CO2_Min, "+
	"PP.Hum_Max, PP.Hum_Min, "+
	"PP.Tem_Max, PP.Tem_Min, "+
	"PP.Light_Max, PP.Light_Min "+
	"from dbo.PlantProfile PP where user_ID = ?;";
	public static final String CREATE_PLANT_PROFILE = "insert into SEP4_PMI.PlantProfile (User_ID, Profile_Name, CO2_Max, CO2_Min, Hum_Max, Hum_Min, Tem_Max, Tem_Min, Light_Max, Light_Min) values (?,?,?,?,?,?,?,?,?,?);";
	public static final String UPDATE_PLANT_PROFILE = "update SEP4_PMI.PlantProfile set User_ID = ?, Profile_Name = ?, CO2_Max = ?, CO2_Min = ?, Hum_Max = ?, Hum_Min = ?, Tem_Max = ?, Tem_Min = ?, Light_Max = ?, Light_Min = ? where Profile_ID = ?;";
	public static final String DELETE_PLANT_PROFILE = "delete from SEP4_PMI.PlantProfile where Profile_ID = ?;";

	// TODO: When querying a user, we need to get all of his plant profiles and plants. E.g. with JOIN statements.
	public static final String GET_USER = "select * from SEP4_PMI.Users where User_ID = ?;";
	public static final String CREATE_USER = "insert into SEP4_PMI.Users(User_ID, Password) values (?,?);";
	public static final String UPDATE_USER = "update SEP4_PMI.Users set User_ID = ?, Password = ? where User_ID = ?;";
	public static final String DELETE_USER = "delete from SEP4_PMI.Users where User_ID = ?;";

	public static final String GET_PLANTINFO = "select * from SEP4_PMI.PlantInfo where ID = ?;";
	public static final String CREATE_PLANTINFO = "insert into SEP4_PMI.PlantInfo(Plant_ID, Sensor_Type, Sensor_Value, TimeStamp) values (?,?,?,?);";/*CURRENT_TIMESTAMP instead of the last ? If you want the stamp from the Microsoft SQL server. Else retreive before on java server or device.*/
	public static final String UPDATE_PLANTINFO = "update SEP4_PMI.PlantInfo set ID = ?, Plant_ID = ?, Sensor_Type  = ?, Sensor_Value = ?, TimeStamp = ? where Plant_ID = ?;";
	public static final String DELETE_PLANTINFO = "delete from SEP4_PMI.PlantInfo where ID = ?;";
}
