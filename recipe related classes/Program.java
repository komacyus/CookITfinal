package com.example.mycookit.Classes;



import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Program {

    public static Ingredient[] ingredientTypes;
    public static ArrayList<IngredientInRecipe> currIngredients;
    public static ArrayList<Recipe> cookableWithCurrents;
    public static ArrayList<Recipe> getCookableWithExtras;
    public static Recipe[] allRecipes;
    public static Recipe[] breakfastRecipes;
    public static Recipe[] lunchRecipes;
    public static Recipe[] dinnerRecipes;


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
