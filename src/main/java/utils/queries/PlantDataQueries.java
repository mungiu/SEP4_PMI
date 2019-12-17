package utils.queries;

public class PlantDataQueries {
    public static final String GET_PLANT_DATA_BY_TYPE_AND_PLANT_ID = "select top 1 PD.Data_ID, PD.sensor_type, PD.sensor_value, PD.timestamp from SEP4_PMI.dbo.PlantData PD where PD.Sensor_Type = ? AND PD.Plant_ID = ? ORDER BY PD.TimeStamp DESC;";
    public static final String CREATE_PLANT_DATA = "insert into SEP4_PMI.dbo.PlantData(Plant_ID, Sensor_Type, Sensor_Value, TimeStamp) values (?,?,?,?);";
}
