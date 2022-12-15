package main.java.com.example.mycookit;

public class CurrentIngredient extends Ingredient{

    private Ingredient ingredient;
    private double amount;


    public CurrentIngredient(Ingredient ingredient, double amount){
        this.ingredient = ingredient;
        this.amount = amount;
    }
    
}
