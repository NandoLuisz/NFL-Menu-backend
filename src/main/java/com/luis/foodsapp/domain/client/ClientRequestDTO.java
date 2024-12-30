package com.luis.foodsapp.domain.client;

public record ClientRequestDTO(String email, String order_details, Float total_price, String address) {
}
