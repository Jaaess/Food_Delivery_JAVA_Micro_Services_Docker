package com.ensi.ilsi.foodDelivery.Controller;


import org.springframework.web.bind.annotation.*;

import com.ensi.ilsi.foodDelivery.Entity.Customer;
import com.ensi.ilsi.foodDelivery.Services.CustomerService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> findAll() {
        return this.customerService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Customer> findById(@PathVariable Integer id) {
        return this.customerService.findById(id);
    }

  

    @PostMapping
    public Customer create(Customer customer) {
        return this.customerService.create(customer);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        this.customerService.delete(id);
    }

}

