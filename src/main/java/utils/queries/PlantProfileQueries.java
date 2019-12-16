package utils.queries;

public class PlantProfileQueries {
    public static final String GET_PLANT_PROFILES = "select PP.Profile_Id, PP.Profile_Name," +
            "PP.CO2_Max, PP.CO2_Min,	" +
            "PP.Hum_Max, PP.Hum_Min,	" +
            "PP.Tem_Max, PP.Tem_Min,	" +
            "PP.Light_Max, PP.Light_Min " +
            "from SEP4_PMI.dbo.PlantProfile PP " +
            "join SEP4_PMI.dbo.[Users] u on PP.[User_ID] = u.[User_ID] " +
            "where Email = ?;";
    public static final String CREATE_PLANT_PROFILE = "insert into SEP4_PMI.dbo.PlantProfile (User_ID, Profile_Name, CO2_Max, CO2_Min, Hum_Max, Hum_Min, Tem_Max, Tem_Min, Light_Max, Light_Min)\n" +
            "values ((SELECT [User_ID] FROM SEP4_PMI.dbo.[Users] WHERE Email=?), ? , ?, ?, ?, ?, ?, ?, ? ,?);";
    public static final String UPDATE_PLANT_PROFILE = "update SEP4_PMI.dbo.PlantProfile set Profile_Name = ?, CO2_Min = ?, CO2_Max = ?, Hum_Min = ?, Hum_Max = ?, Tem_Min = ?, Tem_Max = ?, Light_Min = ?, Light_Max = ? where Profile_ID = ?;";
    public static final String DELETE_PLANT_PROFILE = "delete from SEP4_PMI.dbo.PlantProfile where Profile_ID = ?;";
}
