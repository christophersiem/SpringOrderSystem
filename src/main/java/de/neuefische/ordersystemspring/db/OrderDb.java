package de.neuefische.ordersystemspring.db;


import de.neuefische.ordersystemspring.model.Order;
import de.neuefische.ordersystemspring.model.Product;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
@Repository
public class OrderDb {

    public ArrayList<Order> orders = new ArrayList<>();



    public void addOrder(Order newOrder) {
        this.orders.add(newOrder);
    }

    public List<Order> getOrders() {
        return orders;
    }
}

