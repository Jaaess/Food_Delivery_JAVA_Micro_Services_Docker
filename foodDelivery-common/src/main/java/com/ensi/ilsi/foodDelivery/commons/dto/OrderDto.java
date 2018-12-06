package com.ensi.ilsi.foodDelivery.commons.dto;

import com.ensi.ilsi.foodDelivery.commons.enumeration.OrderStatus;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class OrderDto {
    private Long id;
    private BigDecimal totalPrice;
    private OrderStatus status;
    private ZonedDateTime shipped;
    private PaymentDto payment;
    private String customerAdress ;
    private Set<OrderItemDto> orderItems;
}
