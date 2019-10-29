import model.OrderList;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import setup.MockDatabase;
import service.OrderService;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class GetAllOrders {

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
    public void getOrdersWhenEmptyDatabase() {
        try {
            database.cleanDatabase();
            OrderList orders = orderService.getAllOrders();

            System.out.println(orders.getOrders());

            assertNotNull(orders);
            assertTrue(orders.getOrders().size() == 0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // One
    @Test
    public void getAllOrders() {
        try {
            OrderList orders = orderService.getAllOrders();

            assertNotNull(orders);
            assertNotNull(orders.getOrders());
            assertNotNull(orders.getOrders().get(0));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getAllOrdersTwice() {
        try {
            OrderList orderList = orderService.getAllOrders();
            OrderList orderList2 = orderService.getAllOrders();

            assertNotNull(orderList);
            assertNotNull(orderList2);
            assertNotNull(orderList.getOrders().get(0));
            assertNotNull(orderList2.getOrders().get(0));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}