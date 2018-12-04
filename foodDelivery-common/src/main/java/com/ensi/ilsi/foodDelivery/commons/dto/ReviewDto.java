package com.ensi.ilsi.foodDelivery.commons.dto;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class ReviewDto {
    private Long id;
    private String title;
    private String description;
    private Long rating;
    private CustomerDto customerDto;
}
