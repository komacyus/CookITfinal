package com.example.recipeclasses;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;



public class Recipe {

    private String name;


    private boolean isFavorite;
    private boolean isCookableWithCurrent;
    private boolean isCookableWithExtra;
    private double missingAmountToCookThis;
    private double missingPriceToCookThis;
    private String inputTypeOfMissingIngredient;
    private String nameOfTheMissingIngToCookThis;
    private String URLofMissingIngToCookThis;
    private String mealType;
    private ArrayList<IngredientInRecipe> ingsInRecipe = new ArrayList<IngredientInRecipe>();
    private ArrayList<String> stepsList = new ArrayList<String>();





    public Recipe(String name, String... str){

        this.name = name;

        StringTokenizer stringTokenizer;

        for (int i = 0; i< str.length ;i++){
            if(str[i].charAt(0) == '*'){
                stringTokenizer = new StringTokenizer(str[i].substring(1), " ");
                double consumeTypeAmount = Double.parseDouble(stringTokenizer.nextToken());
                String input = stringTokenizer.nextToken();
                String nameOfIng = stringTokenizer.nextToken();



                Ingredient ing = Program.ingredientTypes[Program.findIndexOnIngTypeList(nameOfIng)];

                IngredientInRecipe inginrec = new IngredientInRecipe(ing,consumeTypeAmount);

                ingsInRecipe.add(inginrec);
                
                
            }
            else if(str[i].charAt(0) == '-'){
                this.stepsList.add(str[i].substring(1));
            }
        }
    }

    public void setURLofMissingIngToCookThis(String URLofMissingIngToCookThis) {
        this.URLofMissingIngToCookThis = URLofMissingIngToCookThis;
    }

    public String getURLofMissingIngToCookThis() {
        return URLofMissingIngToCookThis;
    }

    public String getNameOfTheMissingIngToCookThis() {
        return nameOfTheMissingIngToCookThis;
    }

    public void setNameOfTheMissingIngToCookThis(String nameOfTheMissingIngToCookThis) {
        this.nameOfTheMissingIngToCookThis = nameOfTheMissingIngToCookThis;
    }


    public String getInputTypeOfMissingIngredient() {
        return inputTypeOfMissingIngredient;
    }

    public void setInputTypeOfMissingIngredient(String inputTypeOfMissingIngredient) {
        this.inputTypeOfMissingIngredient = inputTypeOfMissingIngredient;
    }

    public ArrayList<String> getStepsList() {
        return stepsList;
    }

    public double getMissingAmountToCookThis() {
        return missingAmountToCookThis;
    }

    public double getMissingPriceToCookThis() {
        return missingPriceToCookThis;
    }

    public void setMissingAmountToCookThis(double missingAmountToCookThis) {
        this.missingAmountToCookThis = missingAmountToCookThis;
    }

    public void setMissingPriceToCookThis(double missingPriceToCookThis) {
        this.missingPriceToCookThis = missingPriceToCookThis;
    }

    public void setStepsList(ArrayList<String> stepsList) {
        this.stepsList = stepsList;
    }


    public String getName() {
        return name;
    }

    public ArrayList<IngredientInRecipe> getIngsInRecipe() {
        return ingsInRecipe;
    }



    public String getMealType() {
        return mealType;
    }

    public void setCookableWithCurrent(boolean cookableWithCurrent) {
        isCookableWithCurrent = cookableWithCurrent;
    }

    public void setCookableWithExtra(boolean cookableWithExtra) {
        isCookableWithExtra = cookableWithExtra;
    }



    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }

    public void setIngsInRecipe(ArrayList<IngredientInRecipe> ingsInRecipe) {
        this.ingsInRecipe = ingsInRecipe;
    }

    public void setMealType(String mealType) {
        this.mealType = mealType;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addToFavorites(){
        setFavorite(true);
    }     
}


