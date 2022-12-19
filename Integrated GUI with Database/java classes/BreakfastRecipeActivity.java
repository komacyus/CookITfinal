package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class BreakfastRecipeActivity extends AppCompatActivity implements RecyclerViewInterface{


    ArrayList<RecipeModel> recipeModels = new ArrayList<>();
    int[] breakfastImages = {R.drawable.eggsalad, R.drawable.menemen};





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breakfast_recipe);


        RecyclerView bRecyclerView = findViewById(R.id.breakfast_list);
        setUpRecipeModels();

        Breakfast_RecyclerViewAdapter adapter =new Breakfast_RecyclerViewAdapter(this, recipeModels, this);
        bRecyclerView.setAdapter(adapter);
        bRecyclerView.setLayoutManager(new LinearLayoutManager(this));





    }
    private void setUpRecipeModels(){
        String[] breakfastRecipeNames = getResources().getStringArray(R.array.breakfastRecipesNames_txt);
        String[] breakfastRecipeDescription = getResources().getStringArray(R.array.breakfastRecipesDescription);

        for (int i = 0; i < breakfastRecipeNames.length; i++) {
            recipeModels.add(new RecipeModel(breakfastRecipeNames[i], breakfastRecipeDescription[i], breakfastImages[i]));
        }
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent( BreakfastRecipeActivity.this, RecipeDetailsActivity.class);
        intent.putExtra("NAME", recipeModels.get(position).getName());
        intent.putExtra("DESCRIPTION", recipeModels.get(position).getDescription());
        intent.putExtra("IMAGE", recipeModels.get(position).getImage());
        startActivity(intent);
    }
}