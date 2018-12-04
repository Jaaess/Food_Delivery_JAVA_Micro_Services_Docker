package com.ensi.ilsi.FoodService.repository;

import com.ensi.ilsi.FoodService.domain.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {
}
