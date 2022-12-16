package com.example.myapplication;

public class CurrentIngredient extends Ingredient{

    private double amount;


    public CurrentIngredient(Ingredient ingredient, double amount){
        super(ingredient);
        this.amount = amount;
    }
    
}
