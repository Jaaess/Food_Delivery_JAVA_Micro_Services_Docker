package com.ensi.ilsi.foodDelivery.OrderService.service;


import com.ensi.ilsi.foodDelivery.OrderService.domain.Order;
import com.ensi.ilsi.foodDelivery.OrderService.domain.OrderItem;
import com.ensi.ilsi.foodDelivery.OrderService.repository.OrderItemRepository;
import com.ensi.ilsi.foodDelivery.OrderService.repository.OrderRepository;
import com.ensi.ilsi.foodDelivery.commons.dto.FoodDto;
import com.ensi.ilsi.foodDelivery.commons.dto.OrderItemDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Slf4j
@Service
@Transactional
public class OrderItemService {

    private final OrderItemRepository orderItemRepository;
    private final OrderRepository orderRepository;
    private final RestTemplate restTemplate;

    public List<OrderItemDto> findAll() {
        log.debug("Request to get all OrderItems");
        return this.orderItemRepository.findAll()
                .stream()
                .map(OrderItemService::mapToDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public OrderItemDto findById(Long id) {
        log.debug("Request to get OrderItem : {}", id);
        return this.orderItemRepository
                .findById(id)
                .map(OrderItemService::mapToDto)
                .orElse(null);
    }

    public OrderItemDto create(OrderItemDto orderItemDto) {
        log.debug("Request to create OrderItem : {}", orderItemDto);
        Order order = this.orderRepository
                .findById(orderItemDto.getOrderId())
                .orElseThrow(
                        () -> new IllegalStateException("The Order does not exist!")
                );

        ResponseEntity<FoodDto> foodResponseEntity
                = this.restTemplate.getForEntity(
                        "http://food-service/api/foods/{id}",
                        FoodDto.class,
                        orderItemDto.getFoodId()
                );

        return mapToDto(
                this.orderItemRepository.save(
                        new OrderItem(
                                orderItemDto.getQuantity(),
                                foodResponseEntity.getBody().getId(),
                                order.getId()
                        )));
    }
 
    public void delete(Long id) {
        log.debug("Request to delete OrderItem : {}", id);
        this.orderItemRepository.deleteById(id);
    }

    public static OrderItemDto mapToDto(OrderItem orderItem) {
        if (orderItem != null) {
            return new OrderItemDto(
                    orderItem.getId(),
                    orderItem.getQuantity(),
                    orderItem.getFoodId(),
                    orderItem.getOrder().getId()
            );
        }
        return null;
    }

   
}
