package com.example.mycookit.Classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import com.example.mycookit.Classes.Program;


public class Recipe {

    private String name;
    private ArrayList<IngredientInRecipe> ingsInRecipe;
    private Description description;
    private boolean isFavorite;
    private boolean isCookableWithCurrent;
    private boolean isCookableWithExtra;
    private String mealType;
    private ArrayList<String> stepsList;

    public Recipe(File file) throws FileNotFoundException {
        Scanner sc = new Scanner(file);
        String line;
        StringTokenizer str;
        double amount;
        String nameOfIngredient, inputType;
        int inputTypeInt;
        Ingredient ingredient;
        int indexOfIngredient = -1;
        while(sc.hasNextLine()){
            line = sc.nextLine();
            if(line.charAt(0) == '*'){
                str = new StringTokenizer(line.substring(1), " ");
                amount= Double.parseDouble(str.nextToken());
                inputType = str.nextToken();
                name = str.nextToken();
                
                if(inputType.equalsIgnoreCase("unit")){
                    inputTypeInt = 0;
                }
                else if(inputType.equalsIgnoreCase("kg")){
                    inputTypeInt = 1;
                }
                else if(inputType.equalsIgnoreCase("volume")){
                    inputTypeInt = 2;
                }
                else {
                    inputTypeInt = 3;
                }
                
                for (int i = 0; i < Program.ingredientTypes.length; i++){
                    if (Program.ingredientTypes[i].getName() == name){
                        indexOfIngredient = i;
                    }
                }

                ingredient = Program.ingredientTypes[indexOfIngredient];
                
                ingsInRecipe.add(new IngredientInRecipe(ingredient, amount));
                
            }
            if(line.charAt(0) == '-'){
                stepsList.add(line.substring(1));
            }
        }
    }


    public String getName() {
        return name;
    }

    public ArrayList<IngredientInRecipe> getIngsInRecipe() {
        return ingsInRecipe;
    }

    public Description getDescription() {
        return description;
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

    public void setDescription(Description description) {
        this.description = description;
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


