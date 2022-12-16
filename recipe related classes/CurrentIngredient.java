package com.example.mycookit;

public class CurrentIngredient {

    private Ingredient ingredient;
    private double amount;
    private int currentUnit;


    public CurrentIngredient(Ingredient ingredient, double amount, int currentUnit){
        this.ingredient = ingredient;
        this.amount = amount;
        this.currentUnit = currentUnit;
    }
    
}
