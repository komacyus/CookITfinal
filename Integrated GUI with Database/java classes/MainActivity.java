package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    ProgressDialog dialog;
    ImageButton suggestRecipe, favorites, searchRecipe, manageIngredients;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout linearLayout = findViewById(R.id.main_layout);
        AnimationDrawable animationDrawable = (AnimationDrawable) linearLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2500);
        animationDrawable.setExitFadeDuration(5000);
        animationDrawable.start();

        suggestRecipe = findViewById(R.id.recipe_button);
        favorites = findViewById(R.id.favorites_button);
        searchRecipe = findViewById(R.id.search_button);
        manageIngredients = findViewById(R.id.ingredient_list_button);


        suggestRecipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goSuggest = new Intent(MainActivity.this, SuggestMeRecipeActivity.class);
                startActivity(goSuggest);
                Calculator calc = new Calculator();
                calc.execute();
                System.out.println(Program.cookableWithCurrents);
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
        Content c = new Content();
        c.execute();
    }
    @Override
    protected void onStop() {
        super.onStop();

        System.out.println(Program.currIngredients);

    }

    private class Calculator extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            Searcher.fillCookableWithCurrentsList();

            try {
                Searcher.fillCookableWithExtrasList();
                System.out.println(Program.cookableWithExtras);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }
    }



    private class Content extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... voids) {

            try {
                Program prog = new Program();
                System.out.println(prog.currIngredients);
                System.out.println(prog.currIngredients);

            } catch (IOException e) {
                e.printStackTrace();
            }


            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }
    }
}