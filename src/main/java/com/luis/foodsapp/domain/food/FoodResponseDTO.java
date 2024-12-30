package com.luis.foodsapp.domain.food;

public record FoodResponseDTO(Long id,
                              String title,
                              String image,
                              String type,
                              String description,
                              Float price) {
    public FoodResponseDTO(Food food){
        this(food.getId(), food.getTitle(), food.getImage(), food.getType(), food.getDescription(), food.getPrice());
    }
}
