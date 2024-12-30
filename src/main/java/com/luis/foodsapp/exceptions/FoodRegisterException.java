package com.luis.foodsapp.exceptions;

public class FoodRegisterException extends RuntimeException{
    public FoodRegisterException() { super("Food Register Failed."); }

    public FoodRegisterException(String message) { super(message); }
}
