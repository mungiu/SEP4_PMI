package utils;

import config.DatabaseData;
import com.microsoft.sqlserver.jdbc.SQLServerDriver;

import java.sql.*;
import java.util.ArrayList;

public class Database {

    private static Connection connection;
    private static Database instance;

    /**
     * private Database constructor
     *
     * @parameter Connection
     */
    private Database() {
    }

    // If a connection already exist, return it, else create a new connection.
    // Does it make sense to close the database connection after every request?
    /**
     * Get the instance of the Database class
     *
     * @return Database
     */
    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    /**
     * Creates a new database connection through JDBC driver
     *
     * @return connection
     */
    private static Connection getNewConnection() {
        try {
            connection = DriverManager.getConnection(DatabaseData.MY_SQL_URL, DatabaseData.DB_USERNAME, DatabaseData.DB_PASSWORD);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;
    }

    public ArrayList<Object[]> query(String sql, Object... statementElements) throws SQLException {
        getNewConnection();
        PreparedStatement statement = null;
        ArrayList<Object[]> list = null;
        ResultSet resultSet = null;
        if (sql != null && statement == null) {
            statement = connection.prepareStatement(sql);
            if (statementElements != null) {
                for (int i = 0; i < statementElements.length; i++)
                    statement.setObject(i + 1, statementElements[i]);
            }
        }
        resultSet = statement.executeQuery();
        list = new ArrayList<Object[]>();
        while (resultSet.next()) {
            Object[] row = new Object[resultSet.getMetaData().getColumnCount()];
            for (int i = 0; i < row.length; i++) {
                row[i] = resultSet.getObject(i + 1);
            }
            list.add(row);
        }
        if (resultSet != null)
            resultSet.close();
        if (statement != null)
            statement.close();
        closeDatabase();
        return list;
    }

    public int update(String sql, Object... statementElements) throws SQLException {
        getNewConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        if (statementElements != null) {
            for (int i = 0; i < statementElements.length; i++)
                statement.setObject(i + 1, statementElements[i]);
        }

        int result = statement.executeUpdate();

        closeDatabase();
        return result;
    }

    private void closeDatabase() throws SQLException {
        connection.close();
    }
}
