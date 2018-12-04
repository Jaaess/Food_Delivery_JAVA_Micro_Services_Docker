package com.ensi.ilsi.foodDelivery.OrderService.repository;

import com.ensi.ilsi.foodDelivery.OrderService.domain.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
