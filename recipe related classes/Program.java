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


    public static void fillIngredientTypesList(Ingredient[] ingredients){
        ingredients[0] = new Ingredient("Onion",10, 5, "https://getir.com/en/product/onions-yTzj4LRUG0/");
        ingredients[1] = new Ingredient("Garlic", 0, 0, "https://getir.com/en/product/garlic-iMUipaQ3du/");
        ingredients[2] = new Ingredient("Tomato", 10, 8, "https://getir.com/en/product/tomatoes-V20EjsVe9f/");
        ingredients[3] = new Ingredient("Carrot", 10, 8, "https://getir.com/en/product/carrots-JDeHsirl3B/");
        ingredients[4] = new Ingredient("Potato", 10, 5, "https://getir.com/en/product/potatoes-skTF2UOKPB/");
        ingredients[5] = new Ingredient("Mushroom", 1, 0, "https://getir.com/en/product/mushroom-x3dOI5I1PH/");
        ingredients[6] = new Ingredient("Eggplant", 10, 5, "https://getir.com/en/product/eggplant-ntLXosWaIP/");
        ingredients[7] = new Ingredient("Lemon", 0, 0, "https://getir.com/en/product/lemon-ZE9tYIwVO1/");
        ingredients[8] = new Ingredient("Cucumber", 10, 8, "https://getir.com/en/product/cengelkoy-cucumbers-Iaqeb5cvWK/");
        ingredients[9] = new Ingredient("Butter", 10, 1, "https://getir.com/en/product/sutas-yayik-tereyagi-jZOUi9pxxR/");
        ingredients[10] = new Ingredient("Egg", 0, 0, "https://getir.com/en/product/cp-medium-size-omega-3-egg-eoM3sEWmjV/");
        ingredients[11] = new Ingredient("Milk", 23, 5, "https://getir.com/en/product/icim-3-milk-gOKo1534BN/");
        ingredients[12] = new Ingredient("Meat", 1, 0, "https://getir.com/en/more/product/bonfilet-20-fat-ground-beef-cPljHa1Xoi/");
        ingredients[13] = new Ingredient("Chicken", 1, 0, "https://getir.com/en/more/product/gedik-chicken-breast-fillets-nrHgnHZ8J0/");
        ingredients[14] = new Ingredient("Flaur", 13, 10, "https://getir.com/en/more/product/sinangil-un-Zwl6gHRi2y/");
        ingredients[15] = new Ingredient("Rice", 13, 6, "https://getir.com/en/product/yayla-yerli-pilavlik-pirinc-IwtDiqY1kT/");
        ingredients[16] = new Ingredient("Spaghetti", 0, 0, "https://getir.com/en/product/oba-spaghetti-makarna-500-gr-ttyqnzvura/");
        ingredients[17] = new Ingredient("Olive Oil", 24, 65, "https://getir.com/en/more/product/yudum-egemden-riviera-zeytinyagi-Qr9Ju0LHAA/");

        
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
