package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static Connection connection;

    // TODO: MOVE THIS TO THE ENV. VARIABLES or CONFIG FILE
    public static final String DB_NAME = "SEP4_PMI";
    private static String serverName = "192.168.87.193";
    private static int portNumber = 1433;
    private static String dbUsername = "remote";
    private static String dbPassword = "iamremote1!";
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
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(mysqlUrl, dbUsername, dbPassword);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;
    }

    /**
     * This is a helper method used for getting a database name based on the connection url
     *
     * Checks if the connection url is equal to the production or test url and returns name of the database
     *
     * IMPORTANT: This is a 'dirty' version, should be rewrote later
     *
     * @return DB_NAME
     */
    public static String getDbNameFromConnection(Connection connection) {
        String url = "sql7.freemysqlhosting.net";
        try {
            url = connection.getMetaData().getURL();
            System.out.println(url);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return url.equals(mysqlUrl) ? "sql7288442" : "3tl_schema";
    }
}
