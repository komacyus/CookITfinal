package com.example.asdf;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;



public class Recipe {

    private String name;
    private ArrayList<IngredientInRecipe> ingsInRecipe;

    private boolean isFavorite;
    private boolean isCookableWithCurrent;
    private boolean isCookableWithExtra;
    private String mealType;
    private ArrayList<String> stepsList;
    private double amount;
    private String nameOfIng, input;
    private String inputType = "";

    public Recipe(String name, String... str){
        this.name = name;
        StringTokenizer stringTokenizer;
        for (String st : str){
            if(st.charAt(0) == '*'){
                stringTokenizer = new StringTokenizer(st.substring(1), " ");
                amount = Double.parseDouble(stringTokenizer.nextToken());
                input = stringTokenizer.nextToken();
                nameOfIng = stringTokenizer.nextToken();

                if(input.equalsIgnoreCase("spoon")) inputType += '4';
                if(input.equalsIgnoreCase("glass")) inputType += '3';
                if(input.equalsIgnoreCase("volume")) inputType += '2';
                if(input.equalsIgnoreCase("kg")) inputType += '1';
                if(input.equalsIgnoreCase("unit")) inputType += '0';    
                
                ingsInRecipe.add(new IngredientInRecipe(Program.ingredientTypes[Program.findIndexOnIngTypeList(nameOfIng)], amount, Integer.parseInt(inputType)));
                
                
            }
            else if(st.charAt(0) == '-'){
                this.stepsList.add(st.substring(1));
            }
        }
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


