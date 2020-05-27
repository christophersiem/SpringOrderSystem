package de.neuefische.ordersystemspring.db;

import de.neuefische.ordersystemspring.model.Order;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderDb {

    private final List<Order> ordsers = new ArrayList<>((List.of(
            new Order ());



    public List<Order> getOrders() {
    }

    public void add(Order order) {
        this.orders.add(order);
    }
}
