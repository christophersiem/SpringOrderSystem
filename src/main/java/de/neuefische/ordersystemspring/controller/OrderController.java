package de.neuefische.ordersystemspring.controller;

import de.neuefische.ordersystemspring.model.Order;
import de.neuefische.ordersystemspring.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("orders")


public class OrderController {

    private final OrderService service;


    @Autowired
    public OrderController(OrderService service) {
        this.service = service;
    }

    @GetMapping
    public List<Order> getOrder() {
        return service.getOrders();
    }


    @PutMapping
    public Order addorder(@RequestBody Order order) {
        service.addOrder((order));
        return order;
    }
}
