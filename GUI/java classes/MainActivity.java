package com.a.cookit;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    ProgressDialog dialog;
    ImageButton suggestRecipe, favorites, searchRecipe, manageIngredients;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dialog = new ProgressDialog( this);
        dialog.setTitle("Loading...");

        suggestRecipe = findViewById(R.id.recipe_button);
        favorites = findViewById(R.id.favorites_button);
        searchRecipe = findViewById(R.id.search_button);
        manageIngredients = findViewById(R.id.ingredient_list_button);


        suggestRecipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goSuggest = new Intent(MainActivity.this, SuggestMeRecipeActivity.class);
                startActivity(goSuggest);
            }
        });

        favorites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goFavorites = new Intent(MainActivity.this, FavoritesActivity.class);
                startActivity(goFavorites);
            }
        });

        searchRecipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goSearch = new Intent(MainActivity.this, SearchRecipeActivity.class);
                startActivity(goSearch);
            }
        });

        manageIngredients.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goManageIngredients = new Intent(MainActivity.this, ManageCurrentIngredientsActivity.class);
                startActivity(goManageIngredients);
            }
        });
    }
}