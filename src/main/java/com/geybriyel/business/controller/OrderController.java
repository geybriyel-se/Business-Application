package com.geybriyel.business.controller;

import com.geybriyel.business.entity.RepairJO;
import com.geybriyel.business.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.rmi.server.RemoteRef;
import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {
    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/list")
    public String listOrders(Model model) {
        List<RepairJO> orders = orderService.findAll();
        model.addAttribute("orders", orders);
        return "orders/order-list";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {
        RepairJO order = new RepairJO();
        model.addAttribute("order", order);
        return "orders/order-form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("employee") RepairJO order) {
        orderService.save(order);
        return "redirect:/orders/list";
    }
}
