package com.ensi.ilsi.FoodService.web;

import com.ensi.ilsi.foodDelivery.dto.FoodDto;
import com.ensi.ilsi.FoodService.domain.Food;
import com.ensi.ilsi.FoodService.repository.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.ensi.ilsi.FoodService.service.FoodService;
import java.util.List;

import static com.ensi.ilsi.foodDelivery.util.Web.API;


@RequiredArgsConstructor
@RestController
@RequestMapping(API + "/foods")
public class FoodResource {

    private  FoodService foodService;

    @GetMapping
    public List<FoodDto> findAll() {
        return this.foodService.findAll();
    }

    @GetMapping("/{id}")
    public FoodDto findById(@PathVariable Long id) {
        return this.foodService.findById(id);
    }

    @PostMapping
    public FoodDto create(@RequestBody FoodDto FoodDto) {
        return this.foodService.create(FoodDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.foodService.delete(id);
    }
}
