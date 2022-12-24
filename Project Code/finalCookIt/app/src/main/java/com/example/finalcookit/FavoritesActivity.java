package com.example.finalcookit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import com.example.finalcookit.FavoriteRecipe;
import com.example.finalcookit.FavoriteRecipeViewModel;

import java.util.ArrayList;
import java.util.List;

public class FavoritesActivity extends AppCompatActivity implements RecyclerViewInterface{
    static ArrayList<RecipeModel> recipeModels;
    int[] images = {R.drawable.eggsalad, R.drawable.menemen,R.drawable.mercimeksoup, R.drawable.lunchspagetti,R.drawable.chickensaute, R.drawable.meatballs};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);
        FavoriteRecipeViewModel viewModel = new ViewModelProvider(this).get(FavoriteRecipeViewModel.class);

        ///////////////////////////



        ////////////////////////////
        RecyclerView fRecyclerView = findViewById(R.id.favorites_list);

        viewModel.getRecipeList().observe(this, listOfRecipes ->{
            recipeModels = new ArrayList<RecipeModel>();
            for(FavoriteRecipe rep: listOfRecipes){
                String name = rep.name;
                String description = rep.description;
                int image = rep.image;
                recipeModels.add(new RecipeModel(name,description,image));
            }
            Breakfast_RecyclerViewAdapter adapter = new Breakfast_RecyclerViewAdapter(this, recipeModels, this);
            fRecyclerView.setAdapter(adapter);
            fRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        });









      ///////////////////////////
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent( FavoritesActivity.this, RecipeDetailsActivity.class);
        intent.putExtra("NAME", recipeModels.get(position).getName());
        intent.putExtra("DESCRIPTION", recipeModels.get(position).getDescription());
        intent.putExtra("IMAGE", recipeModels.get(position).getImage());
        startActivity(intent);
    }
}