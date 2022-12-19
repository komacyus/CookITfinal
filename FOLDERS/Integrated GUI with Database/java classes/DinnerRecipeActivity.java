package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class DinnerRecipeActivity extends AppCompatActivity implements RecyclerViewInterface {

    ArrayList<RecipeModel> recipeModels = new ArrayList<>();
    int[] dinnerImages = {R.drawable.chickensaute, R.drawable.meatballs};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dinner_recipe);


        RecyclerView dRecyclerView = findViewById(R.id.dinner_list);
        setUpRecipeModels();

        Breakfast_RecyclerViewAdapter adapter =new Breakfast_RecyclerViewAdapter(this, recipeModels, this);
        dRecyclerView.setAdapter(adapter);
        dRecyclerView.setLayoutManager(new LinearLayoutManager(this));




    }

    private void setUpRecipeModels(){
        String[] dinnerRecipeNames = getResources().getStringArray(R.array.dinnerRecipesNames_txt);
        String[] dinnerRecipeDescription = getResources().getStringArray(R.array.dinnerRecipesDescription);

        for (int i = 0; i < dinnerRecipeNames.length; i++) {
            recipeModels.add(new RecipeModel(dinnerRecipeNames[i], dinnerRecipeDescription[i], dinnerImages[i]));
        }
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent( DinnerRecipeActivity.this, RecipeDetailsActivity.class);
        intent.putExtra("NAME", recipeModels.get(position).getName());
        intent.putExtra("DESCRIPTION", recipeModels.get(position).getDescription());
        intent.putExtra("IMAGE", recipeModels.get(position).getImage());
        startActivity(intent);
    }
}