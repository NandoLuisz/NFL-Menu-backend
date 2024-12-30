package com.luis.foodsapp.domain.food;

public record FoodRequestDTO(String title,
                             String image,
                             String type,
                             String description,
                             Float price){
}
