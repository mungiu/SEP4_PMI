import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import service.OrderService;
import model.Order;
import setup.MockDatabase;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class DeleteOrder {

    private static MockDatabase database;
    private static OrderService orderService;

    @BeforeClass
    public static void initialize() {
        database = new MockDatabase();
        orderService = new OrderService(database.getConnection());
    }

    @Before
    public void fillDatabase() {
        database.cleanDatabase();
        database.fillDatabase(database.getOrders());
    }

    // Zero
    @Test
    public void deleteOrderThatDoesntExist() {
        try {
            orderService.deleteOrder("543");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // One
    @Test
    public void deleteOneOrder() {
        try {
            orderService.deleteOrder("1");

            Order order = orderService.getOrderById("1");
            assertNull(order);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void deleteMultipleOrders() {
        try {
            orderService.deleteOrder("1");
            orderService.deleteOrder("2");

            Order order = orderService.getOrderById("1");
            Order order2 = orderService.getOrderById("2");
            assertNull(order);
            assertNull(order2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void deleteOrderTwice() {
        try {
            orderService.deleteOrder("1");
            orderService.deleteOrder("1");

            Order order = orderService.getOrderById("1");
            assertNull(order);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}