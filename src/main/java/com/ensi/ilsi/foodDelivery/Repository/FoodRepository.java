package com.ensi.ilsi.foodDelivery.Repository;

import org.springframework.data.repository.CrudRepository;

import com.ensi.ilsi.foodDelivery.Entity.Food;

public interface FoodRepository extends CrudRepository<Food, Integer>{

}
