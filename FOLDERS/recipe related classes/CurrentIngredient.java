package com.example.recipeclasses;

public class CurrentIngredient {

    private Ingredient ingredient;
    private double inputTypeAmount;

    private double consumeTypeAmount;


    public CurrentIngredient(Ingredient ingredient, double inputTypeAmount){
        this.ingredient = ingredient;
        this.inputTypeAmount = inputTypeAmount;
        this.consumeTypeAmount = covertInputAmountToConsumeAmount();



    }

    public double priceBasedOnInputTypeAmount(Double inputTypeAmount){
        return ingredient.getPricePerInputTypeUnit() * inputTypeAmount;
    }

    public double priceBasedOnConsumeTypeAmount(Double consumeTypeAmount){
        return ingredient.getPricePerConsumeTypeUnit() * consumeTypeAmount;
    }



    public double covertInputAmountToConsumeAmount(){
        if(ingredient.getConversion()==0){
            consumeTypeAmount = inputTypeAmount;

        }
        else
        {
            consumeTypeAmount = inputTypeAmount * ingredient.getConversion();

        }
        return inputTypeAmount;
    }


}
