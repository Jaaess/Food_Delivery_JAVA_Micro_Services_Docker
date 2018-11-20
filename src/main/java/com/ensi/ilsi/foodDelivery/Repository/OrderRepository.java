package com.ensi.ilsi.foodDelivery.Repository;

import org.springframework.data.repository.CrudRepository;

import com.ensi.ilsi.foodDelivery.Entity.Order;

public interface OrderRepository extends CrudRepository<Order ,Integer> {

}
