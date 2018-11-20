package com.ensi.ilsi.foodDelivery.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensi.ilsi.foodDelivery.Entity.Order;
import com.ensi.ilsi.foodDelivery.Repository.OrderRepository;

@Service
public class OrderService {
	

    @Autowired
    private OrderRepository orderRepository;

    public Order create(Order Order) {
        return orderRepository.save(Order);
    }
    
    public Order delete(int id) {
    	
        Order order = orderRepository.findById(id).orElseThrow(() 
        		-> new EntityNotFoundException("Order Not Found !"));
        orderRepository.deleteById(id);
        return order;
    }
    
    public List<Order> findAll() {
    	List<Order> orders = new ArrayList<>();
    	orderRepository.findAll().forEach(orders::add);    	
        return orders;
    }
    
    public void deleteAll() {
         orderRepository.deleteAll();
         return;
         }
   
    
    public Optional<Order> findById(int id) {
        return orderRepository.findById(id);
        
    }

 

}
