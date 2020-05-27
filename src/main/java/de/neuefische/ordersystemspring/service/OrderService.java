package de.neuefische.ordersystemspring.service;

import de.neuefische.ordersystemspring.db.OrderDb;
import de.neuefische.ordersystemspring.db.ProductDb;
import de.neuefische.ordersystemspring.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {


    private final OrderDb orderDb;

    @Autowired

    public OrderService(OrderDb orderDb) {
        this.orderDb = orderDb;
    }

    public void addOrder(Order order){
        orderDb.add(order);
    }
    public List<Order> getOrders() {
        return orderDb.getOrders();
    }
}
