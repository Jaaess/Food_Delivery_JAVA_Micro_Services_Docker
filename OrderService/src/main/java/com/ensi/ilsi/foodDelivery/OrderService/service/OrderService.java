package com.ensi.ilsi.foodDelivery.OrderService.service;


import com.ensi.ilsi.foodDelivery.OrderService.domain.Order;
import com.ensi.ilsi.foodDelivery.commons.enumeration.OrderStatus;
import com.ensi.ilsi.foodDelivery.OrderService.repository.OrderRepository;
import com.ensi.ilsi.foodDelivery.commons.dto.CustomerDto;
import com.ensi.ilsi.foodDelivery.commons.dto.OrderDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Slf4j
@Service
@Transactional
public class OrderService {
    
    private final OrderRepository orderRepository;

    public List<OrderDto> findAll() {
        log.debug("Request to get all Orders");
        return this.orderRepository.findAll()
                .stream()
                .map(OrderService::mapToDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public OrderDto findById(Long id) {
        log.debug("Request to get Order : {}", id);
        return this.orderRepository.findById(id).map(OrderService::mapToDto).orElse(null);
    }

    /*
    public List<OrderDto> findAllByUser(Long id) {
        return this.orderRepository.findByCartCustomer_Id(id)
                .stream()
                .map(OrderService::mapToDto)
                .collect(Collectors.toList());
    }
    */

    public OrderDto create(OrderDto orderDto) {
        log.debug("Request to create Order : {}", orderDto);
        return mapToDto(
                this.orderRepository.save(
                        new Order(
                                BigDecimal.ZERO,
                                OrderStatus.CREATION,
                                null,
                                Collections.emptySet(),
                                null
                        )
                )
        );
    }

    public Order createOrder(CustomerDto customer) {
        log.debug("Request to create Order with a Cart : {}", customer);
        return this.orderRepository.save(
                new Order(
                        BigDecimal.ZERO,
                        OrderStatus.CREATION,
                        null,
                        Collections.emptySet(),
                        customer.getAddress()
                )
        );
    }

    public OrderDto create(CustomerDto customer) {
        return mapToDto(this.createOrder(customer));
    }

    public void delete(Long id) {
        log.debug("Request to delete Order : {}", id);
        this.orderRepository.deleteById(id);
    }

    public static OrderDto mapToDto(Order order) {
        if (order != null) {
            return new OrderDto(
                    order.getId(),
                    order.getTotalPrice(),
                    order.getStatus(),
                    order.getShipped(),
                    PaymentService.mapToDto(order.getPayment()),
                    order.getCustomerAdress(),
                   // AddressService.mapToDto(order.getShipmentAddress()),
                    order.getOrderItems().stream().map(OrderItemService::mapToDto).collect(Collectors.toSet())
            );
        }
        return null;
    }
}
