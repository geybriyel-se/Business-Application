package com.geybriyel.business.rest;

import com.geybriyel.business.entity.RepairJO;
import com.geybriyel.business.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderRestController {
    private OrderService orderService;

    @Autowired
    public OrderRestController(OrderService orderService) {
        this.orderService = orderService;
    }

    // Return list of all orders
    @GetMapping("/orders")
    public List<RepairJO> findAll() {
        return orderService.findAll();
    }

    // return an order by id
    @GetMapping("/orders/{orderId}")
    public RepairJO getOrderById(@PathVariable int orderId) {
        RepairJO order = orderService.findById(orderId);

        if (order == null) {
            throw new RuntimeException("Order ID not found - " + orderId);
        }

        return order;
    }
}
