package com.ensi.ilsi.foodDelivery.customerService.service;

import com.ensi.ilsi.foodDelivery.commons.dto.CustomerDto;
import com.ensi.ilsi.foodDelivery.commons.dto.OrderDto;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@FeignClient(name = "order-service")
public interface OrderServiceClient {

    @RequestMapping(value = "/api/orders", method = POST)
    OrderDto create(CustomerDto customertDto);

}
