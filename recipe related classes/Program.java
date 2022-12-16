package com.example.mycookit;

import java.util.ArrayList;

public class Program {

    public Ingredient[] ingredientTypes;
    public ArrayList<IngredientInRecipe> currIngredients;
    public ArrayList<Recipe> cookableWithCurrents;
    public ArrayList<Recipe> getCookableWithExtras;
    public Recipe[] allRecipes;
    public Recipe[] breakfastRecipes;
    public Recipe[] lunchRecipes;
    public Recipe[] dinnerRecipes;


    public static void fillIngredientTypesList(String filename, Ingredient[] ingredients) throws FileNotFoundException {
        File file = new File(filename);
        Scanner scan = new Scanner(file);
        int count = 0;
        while (scan.hasNextLine()) {
            Ingredient i = new Ingredient(scan.next(), scan.nextInt(), scan.nextInt());
            ingredients[count] = i;
            count++;
        }
        scan.close();
    }

    public void fillAllRecipes(){

    }

    public void dillRecipeTypesLists(){

    }

    /**
     *
     * @param name name of ingredient that we are trying to
     *             obtain the amount of.
     * @return amount of the ingredient thas has given name parameter
     */
    public String getCurrentAmount(String name){

        String s = "";
        /*
        for all elements of currIngredients
            if name of element = name
                return amount of element
         */
        return s;
    }


}
