package com.a.cookit;

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
        String[] lunchRecipeNames = getResources().getStringArray(R.array.lunchRecipesNames_txt);
        String[] lunchRecipeDescription = getResources().getStringArray(R.array.lunchRecipesDescription);

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