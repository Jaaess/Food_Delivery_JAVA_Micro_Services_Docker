package com.ensi.ilsi.foodDelivery.OrderService.web;

import com.ensi.ilsi.foodDelivery.OrderService.service.OrderService;
import com.ensi.ilsi.foodDelivery.commons.dto.OrderDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import static com.ensi.ilsi.foodDelivery.commons.util.Web.API;


@RequiredArgsConstructor
@RestController
@RequestMapping(API + "/orders")
public class OrderResource {

    private final OrderService orderService;

    @GetMapping
    public List<OrderDto> findAll() {
        return this.orderService.findAll();
    }

    @GetMapping("/{id}")
    public OrderDto findById(@PathVariable Long id) {
        return this.orderService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.orderService.delete(id);
    }
}
