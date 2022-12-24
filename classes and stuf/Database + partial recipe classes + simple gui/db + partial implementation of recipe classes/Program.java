package com.example.myapplication;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
public class Program {
    public static Ingredient[] ingredientTypes = new Ingredient[11];
    public static ArrayList<CurrentIngredient> currOfUser;
    public static ArrayList<IngredientInRecipe> currIngredients;
    public ArrayList<Recipe> cookableWithCurrents;
    public ArrayList<Recipe> getCookableWithExtras;
    public static Recipe[] allRecipes;
    public static Recipe[] breakfastRecipes;
    public static Recipe[] lunchRecipes;
    public static Recipe[] dinnerRecipes;



    /**
     * @author idil
     */
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

    public void fillRecipeTypesLists(){

    }

    /**
     *
     * @param name name of ingredient that we are trying to
     *             obtain the amount of.
     * @return amount of the ingredient thas has given name parameter
     */
    public static int getIngredientType(String name){
        int ans = 0;
        for(Ingredient r: ingredientTypes){
            if(r.getName().equals(name)){
                ans = r.getInputType();
            }
        }
        /*
        for all elements of currIngredients
            if name of element = name
                return amount of element
         */
        return ans;
    }

    public static int getConv(String name){
        int ans = 0;
        for(Ingredient r: ingredientTypes){
            if(r.getName().equals(name)){
                ans = r.getConversion();
            }
        }
        /*
        for all elements of currIngredients
            if name of element = name
                return amount of element
         */
        return ans;
    }


    public static CurrentIngredient converter(CIngredient c){
        int inputType = Program.getIngredientType(c.name);
        int conv = Program.getConv(c.name);
        CurrentIngredient current = new CurrentIngredient(new Ingredient(c.name, inputType, conv),c.num);
        return current;
    }
}
