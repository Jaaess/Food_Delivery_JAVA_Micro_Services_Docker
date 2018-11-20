package com.ensi.ilsi.foodDelivery.Controller;


import org.springframework.web.bind.annotation.*;

import com.ensi.ilsi.foodDelivery.Entity.Food;
import com.ensi.ilsi.foodDelivery.Services.FoodService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/foods")
public class FoodController {

    private final FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @GetMapping
    public List<Food> findAll() {
        return this.foodService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Food> findById(@PathVariable Integer id) {
        return this.foodService.findById(id);
    }

  

    @PostMapping
    public Food create(Food food) {
        return this.foodService.create(food);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        this.foodService.delete(id);
    }

}

