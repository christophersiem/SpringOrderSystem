package de.neuefische.ordersystemspring.controller;

import de.neuefische.ordersystemspring.model.Order;
import de.neuefische.ordersystemspring.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("orders")


public class OrderController {

    private OrderService service;


    @Autowired
    public OrderController(OrderService service) {
        this.service = service;
    }

    @GetMapping
    public List<Order> listOrders() {
        return service.listOrders();
    }


    @PutMapping
    public Order addOrder(@RequestBody List<String> productIds) {
        return service.addOrder(productIds);
    }


    @GetMapping("{orderId}")
    public List<Order> getOrderById(@PathVariable String orderId){
        return service.findOrderById(orderId);
    }

}
