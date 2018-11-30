package com.ensi.ilsi.foodDelivery.dto;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class ReviewDto {
    private Long id;
    private CustomerDto customerDto;
    private String title;
    private String description;
    private Long rating;
}
