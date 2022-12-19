package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class LunchRecipeActivity extends AppCompatActivity implements RecyclerViewInterface {


    ArrayList<RecipeModel> recipeModels = new ArrayList<>();
    int[] lunchImages = {R.drawable.mercimeksoup, R.drawable.lunchspagetti};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lunch_recipe);

        RecyclerView lRecyclerView = findViewById(R.id.lunch_list);
        setUpRecipeModels();

        Breakfast_RecyclerViewAdapter adapter =new Breakfast_RecyclerViewAdapter(this, recipeModels, this);
        lRecyclerView.setAdapter(adapter);
        lRecyclerView.setLayoutManager(new LinearLayoutManager(this));


    }
    private void setUpRecipeModels(){
        //String[] lunchRecipeNames = getResources().getStringArray(R.array.lunchRecipesNames_txt);
        //String[] lunchRecipeDescription = getResources().getStringArray(R.array.lunchRecipesDescription);

        String[] lunchRecipeNames = {"Mercimek Soup","Spaghetti"};
        String[] lunchRecipeDescription = {"Mercimek Soup\n"+
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
                        "-Dish out, garnish with some parsley and serve immediately.\n"};

        for (int i = 0; i < lunchRecipeNames.length; i++) {
            recipeModels.add(new RecipeModel(lunchRecipeNames[i], lunchRecipeDescription[i], lunchImages[i]));
        }
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent( LunchRecipeActivity.this, RecipeDetailsActivity.class);
        intent.putExtra("NAME", recipeModels.get(position).getName());
        intent.putExtra("DESCRIPTION", recipeModels.get(position).getDescription());
        intent.putExtra("IMAGE", recipeModels.get(position).getImage());
        startActivity(intent);
    }
}