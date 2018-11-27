package com.ensi.ilsi.foodDelivery.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ensi.ilsi.foodDelivery.Entity.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
}
