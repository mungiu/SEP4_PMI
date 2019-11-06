package service;

import model.User;
import utils.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

public class UserService implements IUserService {

    private final SimpleDateFormat SDF;

    public UserService() {
        this.SDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }

    /**
     * Queries a database and returns a specific address
     *
     * @param userID of the address to be returned
     * @return address
     */
    public User getUserById(int userID) throws SQLException {
        Statement statement = Database.getConnection().createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT co.country, ci.city, ci.postcode, ad.street FROM "
                + Database.DB_NAME + ".country AS co" + " LEFT JOIN " + Database.DB_NAME + ".city AS ci ON co.ID_country = ci.ID_country "
                + "AND ci.city IS NOT NULL LEFT JOIN " + Database.DB_NAME + ".address AS ad ON ci.ID_city = ad.ID_city "
                + "AND ID_address ='" + userID
                + "' WHERE ad.street IS NOT NULL;"
        );

        User user = null;
        if (resultSet.next()) {
            user = new User(
                    resultSet.getString("email"),
                    resultSet.getString("password")


            );
        }

        return user;
    }

    @Override
    public void deleteUser(String userID) throws SQLException {
        // TODO
    }

    @Override
    public void updateUser(User user) throws SQLException {
        // TODO
    }

    @Override
    public void createUser(User plant) throws SQLException {
        // TODO
    }
}
