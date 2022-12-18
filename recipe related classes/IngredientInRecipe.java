package com.example.recipeclasses;

public class IngredientInRecipe {
    private Ingredient ingredient;
    private int currentUnit;
    private double inputTypeAmount;
    private double consumeTypeAmount;


    public IngredientInRecipe(Ingredient ingredient, double ConsumeTypeAmount){
        this.ingredient = ingredient;
        this.consumeTypeAmount = consumeTypeAmount;
        this.inputTypeAmount = convertConsumeAmountToInputAmount();


    }

    public double priceBasedOnInputTypeAmount(Double inputTypeAmount){

        return ingredient.getPricePerInputTypeUnit() * inputTypeAmount;
    }

    public double priceBasedOnConsumeTypeAmount(Double consumeTypeAmount){
        return ingredient.getPricePerConsumeTypeUnit() * consumeTypeAmount;
    }

    public double convertConsumeAmountToInputAmount(){
        if(ingredient.getConversion()==0){
            inputTypeAmount = consumeTypeAmount;
        }
        else {
            inputTypeAmount= consumeTypeAmount / ingredient.getConversion();

        }
        return consumeTypeAmount;
    }



}
