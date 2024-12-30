package com.luis.foodsapp.repository;

import com.luis.foodsapp.domain.food.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long> {
    boolean existsByTitle(String title);
}
