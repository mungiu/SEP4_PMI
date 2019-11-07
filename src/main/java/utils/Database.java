package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static Connection connection;

    // TODO: MOVE THIS TO THE ENV. VARIABLES or CONFIG FILE
    public static final String DB_NAME = "SEP4_PMI";
    private static String serverName = "192.168.87.193\\SEP4_PMI";
    private static int portNumber = 1433;
    private static String dbUsername = "SEP4_PMI";
    private static String dbPassword = "#SEP#4_#PMI#_#!";
    private static String mysqlUrl = "jdbc:sqlserver://" + serverName + ":" + portNumber;

    /**
     * Lazy implementation of the database connection
     *
     * @return connection
     */
    public static Connection getConnection() {
        if (connection != null)
            return connection;
        return getNewConnection();
    }

    /**
     * Creates a new database connection through JDBC driver
     *
     * @return connection
     */
    public static Connection getNewConnection() {
        try {
            connection = DriverManager.getConnection(mysqlUrl, dbUsername, dbPassword);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;
    }
}
