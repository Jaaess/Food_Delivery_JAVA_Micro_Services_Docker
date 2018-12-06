package com.ensi.ilsi.foodDelivery.OrderService.repository;

import com.ensi.ilsi.foodDelivery.OrderService.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
