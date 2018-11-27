package com.ensi.ilsi.foodDelivery.Controller;


import org.springframework.web.bind.annotation.*;

import com.ensi.ilsi.foodDelivery.Entity.Payment;
import com.ensi.ilsi.foodDelivery.Services.PaymentService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping
    public List<Payment> findAll() {
        return this.paymentService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Payment> findById(@PathVariable Integer id) {
        return this.paymentService.findById(id);
    }

  

    @PostMapping
    public Payment create(Payment Payment) {
        return this.paymentService.create(Payment);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        this.paymentService.delete(id);
    }

}

