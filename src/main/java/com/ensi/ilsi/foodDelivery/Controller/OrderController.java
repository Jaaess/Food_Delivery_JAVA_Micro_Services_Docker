package com.ensi.ilsi.foodDelivery.Controller;


import org.springframework.web.bind.annotation.*;

import com.ensi.ilsi.foodDelivery.Entity.Order;
import com.ensi.ilsi.foodDelivery.Services.OrderService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Orders")
public class OrderController {

    private final OrderService OrderService;

    public OrderController(OrderService OrderService) {
        this.OrderService = OrderService;
    }

    @GetMapping
    public List<Order> findAll() {
        return this.OrderService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Order> findById(@PathVariable Integer id) {
        return this.OrderService.findById(id);
    }

  

    @PostMapping
    public Order create(Order Order) {
        return this.OrderService.create(Order);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        this.OrderService.delete(id);
    }

}

