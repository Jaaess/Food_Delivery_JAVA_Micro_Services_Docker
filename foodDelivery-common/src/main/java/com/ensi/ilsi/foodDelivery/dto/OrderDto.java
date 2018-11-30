package com.ensi.ilsi.foodDelivery.dto;

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
    private String status;
    private ZonedDateTime shipped;
    private PaymentDto payment;
    private String customerAdress ;
    private Set<OrderItemDto> orderItems;
}
