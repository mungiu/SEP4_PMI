package utils.queries;

public class PlantQueries {
    public static final String GET_PLANTS_BY_USER_ID = "SELECT p.Plant_ID, p.Profile_ID, p.PlantName, p.Device_ID FROM SEP4_PMI.dbo.PlantProfile PP "+
    "right join SEP4_PMI.dbo.Plant p on p.Profile_ID = PP.Profile_ID "+
    "left join SEP4_PMI.dbo.[Users] u on PP.[User_ID] = u.[User_ID] "+
    "WHERE Email = ?;";
    public static final String CREATE_PLANT = "insert into SEP4_PMI.dbo.Plant([Device_ID] ,Profile_ID, PlantName) values (?,?,?);";
    public static final String UPDATE_PLANT = "update SEP4_PMI.dbo.Plant set Device_ID = ?, Profile_ID = ?, PlantName = ? where Plant_ID = ?;";
    public static final String DELETE_PLANT = "delete from SEP4_PMI.dbo.Plant where Plant_ID = ?;";
    public static final String GET_PLANT_ID_BY_DEVICE_ID = "SELECT PLANT_ID FROM SEP4_PMI.dbo.Plant WHERE Device_ID = ?";
}
