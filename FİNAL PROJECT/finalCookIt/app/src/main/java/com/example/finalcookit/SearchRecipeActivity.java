package com.example.finalcookit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class SearchRecipeActivity extends AppCompatActivity {

    ImageButton breakfastButton, lunchButton, dinnerButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_recipe);

        breakfastButton = findViewById(R.id.breakfast_button);
        lunchButton = findViewById(R.id.lunch_button);
        dinnerButton = findViewById(R.id.dinner_button);

        breakfastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goBreakfastRecipes = new Intent(SearchRecipeActivity.this, BreakfastRecipeActivity.class);
                startActivity(goBreakfastRecipes);
            }
        });

        lunchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goLunchRecipes = new Intent(SearchRecipeActivity.this, LunchRecipeActivity.class);
                startActivity(goLunchRecipes);
            }
        });

        dinnerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goDinnerRecipes = new Intent(SearchRecipeActivity.this, DinnerRecipeActivity.class);
                startActivity(goDinnerRecipes);
            }
        });


    }
}