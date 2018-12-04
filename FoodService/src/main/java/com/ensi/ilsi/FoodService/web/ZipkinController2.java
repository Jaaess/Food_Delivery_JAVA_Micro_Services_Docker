package com.ensi.ilsi.FoodService.web;

import java.util.logging.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ZipkinController2 {

    private static final Logger LOG = Logger.getLogger(ZipkinController2.class.getName());

    @GetMapping(value = "/zipkin2")
    public String zipkinService1() {
        LOG.info("Inside zipkinService 2 ..");
        return "Hello...";
    }
}
