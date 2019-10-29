package setup;

import model.Order;
import model.OrderList;
import service.AddressService;
import service.IAddressService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

public class MockDatabase {
    private Connection connection;
    private SimpleDateFormat SDF;
    private OrderList orders;

    public static final String DB_NAME = "3tl_schema";
    private static final String DB_ADDRESS = "127.0.0.1";
    private static final int DB_PORT = 3306;
    private static final String DB_USERNAME = "3tl_admin";
    private static final String DB_PASSWORD = "password";

    public MockDatabase() {
        this.connection = getNewConnection();
        this.SDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.orders = MockOrders.getMockOrders();
    }

    public Connection getConnection() {
        if (connection != null)
            return connection;
        return getNewConnection();
    }

    private Connection getNewConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://" + DB_ADDRESS + ":" + DB_PORT + "/" + DB_NAME + "?autoReconnect=true",
                    DB_USERNAME, DB_PASSWORD);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;
    }

    public OrderList getOrders() {
        return this.orders;
    }

    public void fillDatabase(OrderList orders) {
        IAddressService addressService = new AddressService();
        Statement statement = null;

        try {
            statement = getConnection().createStatement();

            for (Order order : orders.getOrders()) {
                statement.executeUpdate("INSERT INTO " + DB_NAME + ".order VALUES (NULL,"
                        + addressService.getAddressId(order.getPickUpAddress()) + ","
                        + addressService.getAddressId(order.getDropOffAddress())
                        + "," + order.getCompanyID()
                        + ",'" + SDF.format(order.getPickUpDeadline())
                        + "','" + SDF.format(order.getDropOffDeadline())
                        + "'," + order.getPrice()
                        + ",'" + order.getContentDescription()
                        + "','" + order.getSize()
                        + "'," + order.getWeight()
                        + ",'" + order.getContainerSize()
                        + "','" + order.getDistance() + "');"
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void cleanDatabase() {
        Statement statement = null;

        try {
            statement = getConnection().createStatement();

            statement.executeUpdate("DELETE FROM " + DB_NAME + ".takenorders");
            statement.executeUpdate("DELETE FROM " + DB_NAME + ".order");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
