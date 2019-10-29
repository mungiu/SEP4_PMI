package setup;

import model.Address;
import model.OrderList;
import model.Order;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class MockOrders {

    private static OrderList orderList = new OrderList();
    private static Order order1 = new Order(
            "1",
            new Address(
                    "Nylandsalle 50",
                    "Horsens",
                    "8700",
                    "Denmark"
            ),
            new Date(2019, 01, 25),
            new Address(
                    "Moldavska 32",
                    "Kosice",
                    "04023",
                    "Slovakia"
            ),
            new Date(2019, 04, 25),
            "Description for the order",
            "25x20x10",
            1000.0,
            "10x10x5",
            500.0,
            false,
            false,
            false
    );

    private static Order order2 = new Order(
            "2",
            new Address(
                    "Nylandsalle 50",
                    "Horsens",
                    "8700",
                    "Denmark"
            ),
            new Date(2019, 01, 25),
            new Address(
                    "Moldavska 32",
                    "Kosice",
                    "04023",
                    "Slovakia"
            ),
            new Date(2019, 04, 25),
            "Description for the order",
            "25x20x10",
            1000.0,
            "10x10x5",
            500.0,
            false,
            false,
            false
    );

    private static Order order3 = new Order(
            "5",
            new Address(
                    "Nylandsalle 50",
                    "Horsens",
                    "8700",
                    "Denmark"
            ),
            new Date(2019, 01, 25),
            new Address(
                    "Moldavska 32",
                    "Kosice",
                    "04023",
                    "Slovakia"
            ),
            new Date(2019, 04, 25),
            "Description for the order",
            "25x20x10",
            1000.0,
            "10x10x5",
            500.0,
            false,
            false,
            false
    );

    private static Order order4 = new Order(
            "4",
            new Address(
                    "Nylandsalle 50",
                    "Horsens",
                    "8700",
                    "Denmark"
            ),
            new Date(2019, 01, 25),
            new Address(
                    "Moldavska 32",
                    "Kosice",
                    "04023",
                    "Slovakia"
            ),
            new Date(2019, 04, 25),
            "Description for the order",
            "25x20x10",
            1000.0,
            "10x10x5",
            500.0,
            false,
            false,
            false
    );

    public static OrderList getMockOrders() {
        orderList.getOrders().addAll(new ArrayList<Order>(Arrays.asList(order1, order2, order3, order4)));

        return orderList;
    }
}
