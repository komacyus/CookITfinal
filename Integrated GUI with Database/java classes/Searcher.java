package com.example.finalproject;

import java.io.IOException;
import java.util.ArrayList;

public class Searcher {

    ArrayList<Recipe> cookableWithCurrents = new ArrayList<>();

    public static void fillCookableWithCurrentsList(){
        boolean isCookable = true;
        Program.cookableWithCurrents.clear();
        Program.notCookableWithCurrents.clear();

        for(int i = 0; i < Program.allRecipes.length ; i ++){
            for(int k = 0 ; k < Program.allRecipes[i].getIngsInRecipe().size();k++){

                String nameOfIngInRecipe = Program.allRecipes[i].getIngsInRecipe().get(k).getIngredient().getName();


                if(currIngredientsContainsThisIngredient(nameOfIngInRecipe)){
                    double amountOfIngInRecipe = Program.allRecipes[i].getIngsInRecipe().get(k).getInputTypeAmount();
                    CurrentIngredient currIngredientWithTheName = CurrentIngredientWithTheName(nameOfIngInRecipe);
                    double amountOfCurrentRecipeWithSameName = currIngredientWithTheName.getInputTypeAmount();



                    if(amountOfIngInRecipe > amountOfCurrentRecipeWithSameName){
                        isCookable = false;
                        break;
                    }
                    else{
                        isCookable = true;
                    }
                }

                else{
                    isCookable = false;
                    break;
                }


            }
            if(isCookable) {
                Program.allRecipes[i].setCookableWithCurrent(true);
                Program.cookableWithCurrents.add(Program.allRecipes[i]);
            }
            else{
                Program.notCookableWithCurrents.add(Program.allRecipes[i]);
            }
        }

        System.out.println(Program.cookableWithCurrents);
        System.out.println(Program.notCookableWithCurrents);

    }



    public static void fillCookableWithExtrasList() throws IOException {



        for(int i = 0; i < Program.notCookableWithCurrents.size() ; i ++){

            //---------------------------------NOT ENOUGH INGREDIENTS-----------------------------------------

            ArrayList<IngredientInRecipe> notEnoughIngredients = new ArrayList<>();

            for(int k = 0 ; k < Program.notCookableWithCurrents.get(i).getIngsInRecipe().size();k++){

                String nameOfIngInRecipe = Program.allRecipes[i].getIngsInRecipe().get(k).getIngredient().getName();

                if(currIngredientsContainsThisIngredient(nameOfIngInRecipe)){

                    double amountOfIngInRecipe = Program.allRecipes[i].getIngsInRecipe().get(k).getInputTypeAmount();
                    CurrentIngredient currIngredientWithTheName = CurrentIngredientWithTheName(nameOfIngInRecipe);
                    double amountOfCurrentRecipeWithSameName = currIngredientWithTheName.getInputTypeAmount();

                    if(amountOfIngInRecipe > amountOfCurrentRecipeWithSameName)
                    {
                        notEnoughIngredients.add(Program.allRecipes[i].getIngsInRecipe().get(k));
                    }

                }
            }

            //---------------------------------NOT ENOUGH INGREDIENTS-----------------------------------------


            //---------------------------------NON EXISTING INGREDİENTS----------------------------------------

                ArrayList<IngredientInRecipe> missingIngredients = new ArrayList<>();

            for(int k = 0 ; k < Program.notCookableWithCurrents.get(i).getIngsInRecipe().size() ; k++ ) {

                String nameOfIngInRecipe = Program.allRecipes[i].getIngsInRecipe().get(k).getIngredient().getName();

                if(!currIngredientsContainsThisIngredient(nameOfIngInRecipe)){
                    missingIngredients.add(Program.notCookableWithCurrents.get(i).getIngsInRecipe().get(k));
                }

            }
            //---------------------------------NON EXISTING INGREDİENTS----------------------------------------


            int totalNumberOfNeededElements = missingIngredients.size() + notEnoughIngredients.size();

            if(totalNumberOfNeededElements==1) {

                Program.allRecipes[i].setCookableWithExtra(true);
                Program.cookableWithExtras.add(Program.allRecipes[i]);

                if(missingIngredients.size()==1) {

                    double missingAmount = missingIngredients.get(0).getInputTypeAmount();

                    String nameOfMissingIngredient = missingIngredients.get(0).getIngredient().getName();
                    String URLofMissingIngredient = missingIngredients.get(0).getIngredient().getUrl();

                    Program.ingredientTypes[Program.findIndexOnIngTypeList(nameOfMissingIngredient)].scrape();


                    double missingPrice = missingIngredients.get(0).priceBasedOnInputTypeAmount(missingAmount);


                    Program.allRecipes[i].setMissingPriceToCookThis(missingPrice);
                    Program.allRecipes[i].setMissingAmountToCookThis(missingAmount);
                    Program.allRecipes[i].setNameOfTheMissingIngToCookThis(nameOfMissingIngredient);
                    Program.allRecipes[i].setURLofMissingIngToCookThis(URLofMissingIngredient);

                }

                else if(notEnoughIngredients.size()==1) {
                    double neededAmount;
                    double currentAmount;
                    double missingAmount;
                    double missingPrice;

                    String nameOfMissingIngredient = notEnoughIngredients.get(0).getIngredient().getName();

                    neededAmount = notEnoughIngredients.get(0).getInputTypeAmount();
                    currentAmount = CurrentIngredientWithTheName(nameOfMissingIngredient).getInputTypeAmount();
                    missingAmount = neededAmount-currentAmount;

                    Program.ingredientTypes[Program.findIndexOnIngTypeList(nameOfMissingIngredient)].scrape();
                    missingPrice = notEnoughIngredients.get(0).priceBasedOnInputTypeAmount(missingAmount);



                    String URLofMissingIngredient = notEnoughIngredients.get(0).getIngredient().getUrl();



                    Program.allRecipes[i].setMissingPriceToCookThis(missingPrice);
                    Program.allRecipes[i].setMissingAmountToCookThis(missingAmount);
                    Program.allRecipes[i].setNameOfTheMissingIngToCookThis(nameOfMissingIngredient);
                    Program.allRecipes[i].setURLofMissingIngToCookThis(URLofMissingIngredient);

                }
            }
        }

    }





    public static double missingAmountForMissingIngredient(String nameOfMissingIngredient , double neededAmount){
        int indexOfIngredient = Program.findIndexOnIngTypeList(nameOfMissingIngredient);
        CurrentIngredient currentIng = CurrentIngredientWithTheName(nameOfMissingIngredient);
        double currentAmount = currentIng.getInputTypeAmount();
        double missingAmount = neededAmount - currentAmount;

        return missingAmount;

    }


    public static CurrentIngredient CurrentIngredientWithTheName(String name){
        CurrentIngredient CI = null;

        for(int i =0; i< Program.currIngredients.size() ; i++){

            if(Program.currIngredients.get(i).getIngredient().getName().equalsIgnoreCase(name)) {
                CI =  Program.currIngredients.get(i);
                return CI;
            }
            else{
                CI = null;
            }


        }
        return CI;
    }

    public static boolean currIngredientsContainsThisIngredient(String name){

        boolean bl = false;

        for(int i = 0; i < Program.currIngredients.size() ; i++){
            if(Program.currIngredients.get(i).getIngredient().getName().equalsIgnoreCase(name)){
                bl = true;
                return bl;
            }
            else{
                bl = false;
            }
        }

        return bl;
    }

    public static boolean currIngredientIsMoreThanNeededForThisIngredient(IngredientInRecipe ingredientInRecipe,CurrentIngredient currentIngredient){
        //String nameOfCurrIng = Program.currIngredients

        if(currentIngredient.getInputTypeAmount() == ingredientInRecipe.getInputTypeAmount()){
            return true;
        }
        else{
            return false;
        }
    }

}
