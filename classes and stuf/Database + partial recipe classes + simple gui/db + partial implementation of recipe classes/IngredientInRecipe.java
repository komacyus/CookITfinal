package com.example.myapplication;

public class IngredientInRecipe {
    private Ingredient ingredient;
    private double amount;

    public IngredientInRecipe(Ingredient ingredient, double amount){
        this.ingredient = ingredient;
        this.amount = amount;
    }
    public Ingredient getIngredient(){
        return this.ingredient;
    }

    public double getAmount(){
        return this.amount;
    }
}
