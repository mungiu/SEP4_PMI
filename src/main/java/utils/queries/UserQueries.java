package utils.queries;

public class UserQueries {
    public static final String GET_USER_ID_BY_EMAIL = "SELECT [User_ID] FROM SEP4_PMI.dbo.[Users] WHERE Email=?;\n";
    public static final String GET_USER_ID_BY_EMAIL_AND_PASSWORD = "SELECT [User_ID] FROM SEP4_PMI.dbo.[Users] WHERE Email=? AND Password = ?;\n";
    public static final String GET_USER = "select Password from SEP4_PMI.dbo.Users where Email = ?;";
    public static final String CREATE_USER = "insert into SEP4_PMI.dbo.Users(Email, Password) values (?,?);";
    public static final String UPDATE_USER = "update SEP4_PMI.dbo.Users set Email = ?, Password = ? where Email = ?;";
    public static final String DELETE_USER = "delete from SEP4_PMI.dbo.Users where Email = ?;";
}
