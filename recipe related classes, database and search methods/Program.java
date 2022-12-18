package com.example.recipeclasses;



import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Program {

    public static Ingredient[] ingredientTypes;
    public static ArrayList<CurrentIngredient> currIngredients;
    public static ArrayList<Recipe> cookableWithCurrents;
    public static ArrayList<Recipe> getCookableWithExtras;
    public static Recipe[] allRecipes;
    public static Recipe[] breakfastRecipes;
    public static Recipe[] lunchRecipes;
    public static Recipe[] dinnerRecipes;

    public Program() throws IOException {
        ingredientTypes = new Ingredient[22];
        breakfastRecipes = new Recipe[2];
        lunchRecipes = new Recipe[2];
        dinnerRecipes = new Recipe[2];
        allRecipes = new Recipe[6];
        fillIngredientTypesList(this.ingredientTypes);
        fillAllRecipes();
    }


    public void fillIngredientTypesList(Ingredient[] ingredients) throws IOException {

        ingredients[0] = new Ingredient("Onion", 1, 1, 5, "https://getir.com/en/product/onions-yTzj4LRUG0/");
        ingredients[1] = new Ingredient("Garlic", 1, 0, 0, "https://getir.com/en/product/garlic-iMUipaQ3du/");
        ingredients[2] = new Ingredient("Tomato", 1, 0, 8, "https://getir.com/en/product/tomatoes-V20EjsVe9f/");
        ingredients[3] = new Ingredient("Carrot", 1, 0, 8, "https://getir.com/en/product/carrots-JDeHsirl3B/");
        ingredients[4] = new Ingredient("Potato", 1, 0, 5, "https://getir.com/en/product/potatoes-skTF2UOKPB/");
        ingredients[5] = new Ingredient("Mushroom", 1, 1, 0, "https://getir.com/en/product/mushroom-x3dOI5I1PH/");
        ingredients[6] = new Ingredient("Eggplant", 1, 0, 5, "https://getir.com/en/product/eggplant-ntLXosWaIP/");
        ingredients[7] = new Ingredient("Lemon", 1, 0, 0, "https://getir.com/en/product/lemon-ZE9tYIwVO1/");
        ingredients[8] = new Ingredient("Cucumber", 1, 0, 8, "https://getir.com/en/product/cengelkoy-cucumbers-Iaqeb5cvWK/");
        ingredients[9] = new Ingredient("Butter", 1, 4, 70, "https://getir.com/en/product/sutas-yayik-tereyagi-jZOUi9pxxR/");
        ingredients[10] = new Ingredient("Egg", 0, 0, 0, "https://getir.com/en/product/cp-medium-size-omega-3-egg-eoM3sEWmjV/");
        ingredients[11] = new Ingredient("Milk", 2, 3, 5, "https://getir.com/en/product/icim-3-milk-gOKo1534BN/");
        ingredients[12] = new Ingredient("Meat", 1, 1, 0, "https://getir.com/en/more/product/bonfilet-20-fat-ground-beef-cPljHa1Xoi/");
        ingredients[13] = new Ingredient("Chicken", 1, 1, 0, "https://getir.com/en/more/product/gedik-chicken-breast-fillets-nrHgnHZ8J0/");
        ingredients[14] = new Ingredient("Flour", 1, 3, 10, "https://getir.com/en/more/product/sinangil-un-Zwl6gHRi2y/");
        ingredients[15] = new Ingredient("Rice", 1, 3, 6, "https://getir.com/en/product/yayla-yerli-pilavlik-pirinc-IwtDiqY1kT/");
        ingredients[16] = new Ingredient("Spaghetti", 1, 1, 0, "https://getir.com/en/product/oba-spaghetti-makarna-500-gr-ttyqnzvura/");
        ingredients[17] = new Ingredient("Olive_Oil", 2, 4, 65, "https://getir.com/en/more/product/yudum-egemden-riviera-zeytinyagi-Qr9Ju0LHAA/");
        ingredients[18] = new Ingredient("Green_Pepper", 1, 0, 10, "https://getir.com/urun/sivri-biber-wtrG77UZtI/");
        ingredients[19] = new Ingredient("Red_Pepper", 1, 0, 10, "https://getir.com/urun/kapya-biber-PkY92uC96K/");
        ingredients[20] = new Ingredient("Red_Lentil", 1, 3, 7, "https://getir.com/urun/raya-organik-kirmizi-mercimek-i3zc9wdneD/");
        ingredients[21] = new Ingredient("Tomato_Paste", 2, 4, 30, "https://getir.com/en/more/product/tat-pratik-domates-puresi-WImfLiucBT/");


    }

    public void fillAllRecipes() {

        breakfastRecipes[0] = new Recipe("Egg Salad",
                "*3 unit egg",
                "*4 spoon olive_oil",
                "*1 unit lemon",
                "*1 unit red_pepper",
                "*1 unit green_pepper",

                "-Put the eggs in a small saucepan. Cover with water to 1 inch above eggs. Boil eggs. Remove from heat. Drain the water of boiled eggs. Then, leave to cool eggs.",
                "-Peel the boiled eggs. Chop the way you want.",
                "-Put chopped eggs into a serving dish. Add the finely chopped parsley, dill, green onions, mint, olive oil, salt and black pepper. Mix thoroughly.",
                "-Serve"
        );
        breakfastRecipes[1] = new Recipe("Menemen",
                "*1 spoon olive_oil",
                "*1 unit onion",
                "*1 unit green_pepper",
                "*1 spoon butter",
                "*4 unit tomato",
                "*4 unit egg",

                "- Heat oil in a large sauté pan over medium-high heat.  Add onion and peppers and sauté for 5 minutes, stirring occasionally, until softened.",
                "-Reduce heat to medium.  Add the tomatoes, butter plus a generous pinch of salt and black pepper.  Stir until evenly combined, then sauté for 2 more minutes, until the tomatoes are nice and hot.",
                "-Crack the eggs on top of the tomato mixture.  Let the eggs cook for about 1 minute.  Then use a spoon to break the yolks and briefly stir the eggs into the tomato mixture. Continue cooking until the eggs reach your desired level of doneness.",
                "-Serve immediately with your desired garnishes, along with some crusty sliced bread for dipping.");

        lunchRecipes[0] = new Recipe("Mercimek Soup",
                "*3 spoon olive_oil",
                "*1 unit onion",
                "*1 unit carrot",
                "*2 spoon tomato_paste",
                "*1.5 glass red_lentil",

                "-Heat 3 tablespoons olive oil in a large pot (4 quarts or larger) over medium heat. Add the onion and cook, stirring occasionally, for 3 minutes. Add the carrot, and sauté until the vegetables soften, about 5 minutes.",
                "-Add the salça and stir until evenly distributed.",
                "-Let the soup come to a boil.",
                "-Turn the heat to low, place the lid on the pot, and let the soup simmer until the lentils and vegetables are tender, about 20 minutes.",
                "-Remove the soup from the heat. Use an immersion blender to purée the soup or work in batches and purée the soup in a blender with the lid cracked.",
                "-Add lemon juice, salt, and pepper to taste.");
        lunchRecipes[1] = new Recipe("Easy Spaghetti Recipe",
                "*0.25 kg spaghetti",
                "*2 spoon olive_oil",
                "*1 spoon butter",

                "-Cook the spaghetti according to the package instructions until al dente. Drain and set aside.",
                "-Heat up a skillet and add the olive oil and butter. Saute the garlic until aromatic, then add the spaghetti.",
                "-Season with salt, pepper, and chili flakes. Stir to combine well.",
                "-Dish out, garnish with some parsley and serve immediately.");
        dinnerRecipes[0] = new Recipe("Meatballs",

                "*0.8 kg meat",
                "*2 unit onion",

                "-In a large bowl, combine ground beef, breadcrumbs, finely diced onion.",
                "-Add in the spices.",
                "-In a small bowl, mix baking soda and water. Pour this into the ground beef mixture. Mix well with your hand. ",
                "-Knead it for about a minute so that everything is combined well.",
                "-Cover and let it sit in the refrigerator overnight or at least 2-3 hours.",
                "-Roll them into meatballs.",
                "-Heat olive oil in a cast iron pan or any non-stick pan. Cook the meatballs over high heat, flipping them over or shaking the pan occasionally so that all sides are cooked for about 3 minutes.",
                "-Don't overcrowd the pan, cook the meatballs in batches until they finish or save some to freeze."
        );

        dinnerRecipes[1] = new Recipe("Chicken Saute",
                "*1 kg chicken",
                "*1 unit red_pepper",
                "*1 unit green_pepper",
                "*1 unit onion",
                "*5 spoon olive_oil",


                "-Put the olive oil to the saucepan and then add the cubed cut chicken breasts.Saute them at medium heat about 3 minutes. Add sliced onions and continue to saute all until onions get softy. ",
                "-Add the julienne cut peppers and saute them about 7 minutes until peppers get softy.",
                "-Add the soy sauce and continue to stir all about 2-3 minutes. Then add the 1/2 cup of water and close the saucepan lid and let it cook 20 minutes at low-medium heat.",
                "-Serve");


    }


    public static int findIndexOnIngTypeList(String name) {
        for (int i = 0; i < ingredientTypes.length; i++) {

            if (name.equalsIgnoreCase(ingredientTypes[i].getName())) {
                return i;
            }
        }
        return -1;
    }





    public static CurrentIngredient converter(CIngredient c) {
        CurrentIngredient current = null;

        Ingredient ing = Program.ingredientTypes[findIndexOnIngTypeList(c.name)];

        current = new CurrentIngredient(ing , c.num);

        return current;
    }

}
