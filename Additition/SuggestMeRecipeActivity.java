package com.a.cookit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class SuggestMeRecipeActivity extends AppCompatActivity implements  RecyclerViewInterface{
    static ArrayList<RecipeModel> recipeModels = new ArrayList<>();
    int[] images = {R.drawable.eggsalad, R.drawable.menemen,R.drawable.mercimeksoup, R.drawable.lunchspagetti,R.drawable.chickensaute, R.drawable.meatballs};

    static  ArrayList<RecipeModel> cook = new ArrayList<>();
    static  ArrayList<RecipeModel> sugge = new ArrayList<>();

    Button goMarket;

    int cookable = 0;
    int suggestion = 1;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggest_me_recipe);

        setUpRecipeModels();
        //burada intleri alsak cookable = get.....

        cook.add(recipeModels.get(cookable));
        sugge.add(recipeModels.get(suggestion));


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
                Intent goMarket = new Intent(Intent.ACTION_VIEW, Uri.parse("https://stars.bilkent.edu.tr/"));
                startActivity(goMarket);
            }
        });



    }




        private void setUpRecipeModels(){
            String[] allRecipeNames = getResources().getStringArray(R.array.allRecipes);
            String[] allRecipeDescription = getResources().getStringArray(R.array.allDescriptions);

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

}