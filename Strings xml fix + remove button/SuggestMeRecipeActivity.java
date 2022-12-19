package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.finalproject.Program;

import java.util.ArrayList;
/*
* 0 egg salad
* 1 menemen
* 2 mercimek
* 3 spagetti
* 4 meatbals
* 5 chicken saute
*
* */



public class SuggestMeRecipeActivity extends AppCompatActivity implements  RecyclerViewInterface{
    static ArrayList<RecipeModel> recipeModels = new ArrayList<>();
    int[] images = {R.drawable.eggsalad, R.drawable.menemen,R.drawable.mercimeksoup, R.drawable.lunchspagetti,R.drawable.meatballs, R.drawable.chickensaute};

    static  ArrayList<RecipeModel> cook = new ArrayList<>();
    static  ArrayList<RecipeModel> sugge = new ArrayList<>();

    Button goMarket;

    ArrayList<Integer> integersOfCookableWithCurrents = new ArrayList<>();
    int integerOfRecipeCookableWithExtras;
    String url;
    TextView cookableWithCurrentRecipeDetail;
    TextView cookableWithExtraRecipeDetail;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_suggest_me_recipe);

        cookableWithCurrentRecipeDetail = findViewById(R.id.suggestMeRecipeText);
        //cookableWithExtraRecipeDetail = findViewById()



        setUpRecipeModels();

        if(!Program.cookableWithExtras.isEmpty()){
            integerOfRecipeCookableWithExtras = recipeToInteger(Program.cookableWithExtras.get(0));
            sugge.add(recipeModels.get(integerOfRecipeCookableWithExtras));
            url = Program.cookableWithExtras.get(1).getURLofMissingIngToCookThis();
        }

        if(!Program.cookableWithCurrents.isEmpty()){
            for(int i = 0; i<Program.cookableWithCurrents.size();i++){
                integersOfCookableWithCurrents.add(recipeToInteger(Program.cookableWithCurrents.get(i)));
            }
            for(int k = 0; k<integersOfCookableWithCurrents.size() ; k++){
                cook.add(recipeModels.get(integersOfCookableWithCurrents.get(k)));
            }
        }


        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                cookableWithCurrentRecipeDetail.setText(Program.toStringCookableWithCurrents());
                //cookableWithExtraRecipeDetail.setText();
            }
        });






        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) RecyclerView cookableRecyclerView = findViewById(R.id.cookable);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) RecyclerView suggestionRecyclerView = findViewById(R.id.suggestion);

        Breakfast_RecyclerViewAdapter adapter = new Breakfast_RecyclerViewAdapter(this, cook, this);
        cookableRecyclerView.setAdapter(adapter);
        cookableRecyclerView.setLayoutManager(new LinearLayoutManager(this));


        Breakfast_RecyclerViewAdapter adapter2 = new Breakfast_RecyclerViewAdapter(this, sugge, this);
        suggestionRecyclerView.setAdapter(adapter2);
        suggestionRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        goMarket = findViewById(R.id.goMarket);

        goMarket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //url buraya yazılacak
                Intent goMarket = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(goMarket);
            }
        });



    }




        private void setUpRecipeModels(){
            //String[] allRecipeNames = getResources().getStringArray(R.array.allRecipes);
           // String[] allRecipeDescription = getResources().getStringArray(R.array.allDescriptions);

            String[] allRecipeNames = {"Egg Salad", "Menemen","Mercimek Soup", "Spaghetti", "Meatball", "Chicken Saute"};
            String[] allRecipeDescription = {"Egg Salad\n"+
                    "*3 unit egg\n"+
                    "*2 unit green_onion\n"+
                    " *2 unit parsley\n"+
                    "*4 tablespoon olive_oil\n"+
                    "*1 unit lemon\n"+
                    "*2 tablespoon salt\n"+
                    "*1 unit red_pepper\n"+
                    "*1 unit green_pepper\n"+



                    "-Put the eggs in a small saucepan. Cover with water to 1 inch above eggs. Boil eggs. Remove from heat. Drain the water of boiled eggs. Then, leave to cool eggs.\n"+
                    "-Peel the boiled eggs. Chop the way you want.\n"+
                    "-Put chopped eggs into a serving dish. Add the finely chopped parsley, dill, green onions, mint, olive oil, salt and black pepper. Mix thoroughly.\n"+
                    "-Serve\n",
                    "Menemen\n"+

                            "*1 tablespoon olive_oil\n"+
                            "*1 unit onion\n"+
                            "*1 unit green_pepper\n"+
                            "*1 tablespoon butter\n"+
                            "*4 unit tomato\n"+
                            "*4 unit egg\n"+
                            "- Heat oil in a large sauté pan over medium-high heat.  Add onion and peppers and sauté for 5 minutes, stirring occasionally, until softened.\n"+
                            "-Reduce heat to medium.  Add the tomatoes, butter plus a generous pinch of salt and black pepper.  Stir until evenly combined, then sauté for 2 more minutes, until the tomatoes are nice and hot.\n"+
                            "-Crack the eggs on top of the tomato mixture.  Let the eggs cook for about 1 minute.  Then use a spoon to break the yolks and briefly stir the eggs into the tomato mixture. Continue cooking until the eggs reach your desired level of doneness.\n"+
                            "-Serve immediately with your desired garnishes, along with some crusty sliced bread for dipping.\n"
            , "Mercimek Soup\n"+
                    "*3 tablespoon olive_oil\n"+
"*1 unit onion\n"+
"*1 unit carrot\n"+
"*2 tablespoon salça\n"+
"*250 gram red_lentil\n"+
"*1 teaspoon salt\n"+

            "-Heat 3 tablespoons olive oil in a large pot (4 quarts or larger) over medium heat. Add the onion and cook, stirring occasionally, for 3 minutes. Add the carrot, and sauté until the vegetables soften, about 5 minutes.\n"+
                    "-Add the salça and stir until evenly distributed.\n"+
                    "-Let the soup come to a boil.\n"+
            "-Turn the heat to low, place the lid on the pot, and let the soup simmer until the lentils and vegetables are tender, about 20 minutes.\n"+
                    "-Remove the soup from the heat. Use an immersion blender to purée the soup or work in batches and purée the soup in a blender with the lid cracked.\n"+
            "-Add lemon juice, salt, and pepper to taste.\n",
         "Easy Spaghetti Recipe\n"+

"*250 gram spaghetti\n"+
"*2 tablespoon olive_oil\n"+
"*1 tablespoon butter\n"+

            "-Cook the spaghetti according to the package instructions until al dente. Drain and set aside.\n"+
            "-Heat up a skillet and add the olive oil and butter. Saute the garlic until aromatic, then add the spaghetti.\n"+
                    "-Season with salt, pepper, and chili flakes. Stir to combine well.\n"+
            "-Dish out, garnish with some parsley and serve immediately.\n"," Chicken Saute\n"+

                    "*1 kg chicken\n"+
                    "*1 unit red_pepper\n"+
                    "*1 unit green_pepper\n"+
                    "*1 unit onion\n"+
                    "*5 tablespoon olive_oil\n"+
                    "*0.5 glass water\n"+

                    "Put the olive oil to the saucepan and then add the cubed cut chicken breasts. Saute them at medium heat about 3 minutes. Add sliced onions, garlic and continue to saute all until onions get softy.\n"+
            "Add the julienne cut red, orange and green sweet peppers, ground paprika and saute them about 7 minutes until sweet peppers get softy.\n"+
            "Add the soy sauce and continue to stir all about 2-3 minutes. Then add the 1/2 cup of water and close the saucepan lid and let it cook 20 minutes at low-medium heat.\n"
             ,"Meatballs\n"+

                    "*800 gram ground_beef\n"+
"*2 unit onion\n"+
"*2 teaspoon salt\n"+
"*1 teaspoon black_pepper\n"+
"*1 over 4 glass water\n"+
"*1 teaspoon baking soda\n"+

            "1. Get a small onion or some shallots cooking in oil. Once they have softened, let them cool -- they will be going in your meatballs.\n"+
            "2. In a large bowl, mix up the ground meat  with your cooled onions, tomato paste, cheese,  breadcrumbs (I use panko), a splash of milk, and an egg. If it feels too wet, add more breadcrumbs and/or cheese. I love a ton of cheese, to be candid. If you have some parsley or oregano and people who do not balk at green in their meatballs, you may chop a bit up and add it.\n"+
            "3. Make balls in your hand about the size of two golf balls into one. Please keep them uniform so they cook evenly.\n"+
            "4. Refill your frying pan with a enough oil to cover the balls halfway. Get it going till shimmering. (Alternately, you can simmer the balls in your sauce.) Add the balls one at a time. Do not crowd them. You may well have to do this in batches.\n"+
            "5.  Nudge them around the pan with a spatula from time to time. The key here is to keep them from burning, but also to cook them all the way through. You will end up with some that are more crispy than others but just try to control the heat. Pick a sentinel meatball to test for doneness. This should take about ten minutes.\n"+
            "Serve\n"};

            for (int i = 0; i < allRecipeNames .length; i++) {
                recipeModels.add(new RecipeModel(allRecipeNames[i], allRecipeDescription[i], images[i]));
            }
        }

        @Override
        public void onItemClick(int position) {
            Intent intent = new Intent( SuggestMeRecipeActivity.this, RecipeDetailsActivity.class);
            intent.putExtra("NAME", recipeModels.get(position).getName());
            intent.putExtra("DESCRIPTION", recipeModels.get(position).getDescription());
            intent.putExtra("IMAGE", recipeModels.get(position).getImage());
            startActivity(intent);
        }

        public int recipeToInteger(Recipe recipe){

            if(recipe.getName().equalsIgnoreCase("egg salad")){
                return 0;
            }
            else if(recipe.getName().equalsIgnoreCase("menemen")){
                return 1;
            }
            else if(recipe.getName().equalsIgnoreCase("mercimek soup")){
                return 2;
            }
            else if(recipe.getName().equalsIgnoreCase("Easy Spaghetti Recipe")){
                return 3;
            }
            else if(recipe.getName().equalsIgnoreCase("Meatballs")){
                return 4;
            }
            else{
                return 5;
            }

        }



}