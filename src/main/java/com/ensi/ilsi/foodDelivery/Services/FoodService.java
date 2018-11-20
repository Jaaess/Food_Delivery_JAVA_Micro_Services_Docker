package com.ensi.ilsi.foodDelivery.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensi.ilsi.foodDelivery.Entity.Food;
import com.ensi.ilsi.foodDelivery.Repository.FoodRepository;

@Service
public class FoodService {
	

    @Autowired
    private FoodRepository foodRepository;

    public Food create(Food Food) {
        return foodRepository.save(Food);
    }
    
    public Food delete(int id) {
    	
        Food food = foodRepository.findById(id).orElseThrow(() 
        		-> new EntityNotFoundException("Food Not Found !"));
        foodRepository.deleteById(id);
        return food;
    }
    
    public List<Food> findAll() {
    	List<Food> foods = new ArrayList<>();
    	foodRepository.findAll().forEach(foods::add);    	
        return foods;
    }
    
    public void deleteAll() {
         foodRepository.deleteAll();
         return;
         }
   
    
    public Optional<Food> findById(int id) {
        return foodRepository.findById(id);
        
    }

 

}
