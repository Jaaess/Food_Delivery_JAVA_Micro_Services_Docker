package com.ensi.ilsi.foodDelivery.commons.dto;

import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@Data
public class OrderItemDto {
    private Long id;
    private Long quantity;
    private Long FoodId;
    private Long orderId;
}
