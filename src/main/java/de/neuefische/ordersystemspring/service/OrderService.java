package de.neuefische.ordersystemspring.service;

import de.neuefische.ordersystemspring.db.OrderDb;
import de.neuefische.ordersystemspring.db.ProductDb;
import de.neuefische.ordersystemspring.model.Order;
import de.neuefische.ordersystemspring.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrderService {

    private final OrderDb orderDb;
    private final ProductDb productDb;

    @Autowired
    public OrderService(OrderDb orderDb, ProductDb productdDb) {
        this.orderDb = orderDb;
        this.productDb = productdDb;
    }

    public List<Order> listOrders() {
        return orderDb.getOrders();
    }

    public Order addOrder(List<String> productIds) {
        List<Product> productsToOrder = new ArrayList<>();

        for (String productId : productIds) {
            Optional<Product> product = productDb.getProductById(productId);
            if (product.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "product with id " + productId + " not found");
            }
            productsToOrder.add(product.get());
        }

        String uuid = UUID.randomUUID().toString();
        Order newOrder = new Order(uuid, productsToOrder);
        orderDb.addOrder(newOrder);
        return newOrder;
    }

    public List<Order> findOrderById(String orderId) {
        List<Order> orderResult = new ArrayList<>();
        List<Order> orders = orderDb.getOrders();

        for (Order order : orders) {
            if(order.getOrderId().equals(orderId)){
                orderResult.add(order);
            }

        }

        return orderResult;


    }
}

