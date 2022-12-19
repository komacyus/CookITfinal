package com.example.recipeclasses;

import java.util.ArrayList;

public class Searcher {

    ArrayList<Recipe> cookableWithCurrents = new ArrayList<>();

    public static void fillCookableWithCurrentsList(){
        boolean isCookable = true;

        for(int i = 0; i < Program.allRecipes.length ; i ++){
            for(int k = 0 ; k < Program.allRecipes[i].getIngsInRecipe().size();k++){

                String nameOfIngInRecipe = Program.allRecipes[i].getIngsInRecipe().get(k).getIngredient().getName();


                if(currIngredientsContainsThisIngredient(nameOfIngInRecipe)){
                    double amountOfIngInRecipe = Program.allRecipes[i].getIngsInRecipe().get(k).getInputTypeAmount();
                    CurrentIngredient currIngredientWithTheName = CurrentIngredientWithTheName(nameOfIngInRecipe);
                    double amountOfCurrentRecipeWithSameName = currIngredientWithTheName.getInputTypeAmount();

                    if(amountOfIngInRecipe > amountOfCurrentRecipeWithSameName){
                        isCookable = false;
                    }
                    else{isCookable = true;}
                }

            }
            if(isCookable){
                Program.cookableWithCurrents.add(Program.allRecipes[i]);
            }
        }
    }

    public static CurrentIngredient CurrentIngredientWithTheName(String name){
        for(int i =0; i< Program.currIngredients.size() ; i++){

            if(Program.currIngredients.get(i).getIngredient().getName().equalsIgnoreCase(name)) {
                return Program.currIngredients.get(i);
            }
            else{
                return null;
            }
        }

    }

    public static boolean currIngredientsContainsThisIngredient(String name){

        for(int i = 0; i < Program.currIngredients.size() ; i++){
            if(Program.currIngredients.get(i).getIngredient().getName().equalsIgnoreCase(name)){
                return true;
            }
            else{
                return false;
            }
        }

    }

    public static boolean currIngredientIsMoreThanNeededForThisIngredient(IngredientInRecipe ingredientInRecipe,CurrentIngredient currentIngredient){
        String nameOfCurrIng = Program.currIngredients

        if(currentIngredient.getInputTypeAmount() == ingredientInRecipe.getInputTypeAmount()){
            return true;
        }
        else{
            return false;
        }
    }

}
