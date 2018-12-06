package com.ensi.ilsi.foodDelivery.OrderService.repository;

import com.ensi.ilsi.foodDelivery.OrderService.domain.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    
}
