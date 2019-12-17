package utils.queries;

public class WeeklyPlantQueries {
    public static final String GET_WEEKLY_CO2_AVG_OF_PLANT = "SELECT [Date], CO2 FROM Dim_SEP4_PMI.dbo.CO2WeeklyAvgView where Plant_ID = ?;\n";
    public static final String GET_WEEKLY_HUMIDITY_AVG_OF_PLANT = "SELECT [Date], Humidity FROM Dim_SEP4_PMI.dbo.HumWeeklyAvgView where Plant_ID = ?;\n";
    public static final String GET_WEEKLY_TEMPERATURE_AVG_OF_PLANT = "SELECT [Date], TEMPERATURE FROM Dim_SEP4_PMI.dbo.TemWeeklyAvgView where Plant_ID = ?;\n";
    public static final String GET_WEEKLY_LIGHT_AVG_OF_PLANT = "SELECT [Date], LIGHT FROM Dim_SEP4_PMI.dbo.LightWeeklyAvgView where Plant_ID = ?;\n";
}
