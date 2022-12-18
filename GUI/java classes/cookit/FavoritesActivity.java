package com.a.cookit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class FavoritesActivity extends AppCompatActivity implements RecyclerViewInterface{
    static ArrayList<RecipeModel> recipeModels = new ArrayList<>();
    int[] images = {R.drawable.eggsalad, R.drawable.menemen,R.drawable.mercimeksoup, R.drawable.lunchspagetti,R.drawable.chickensaute, R.drawable.meatballs};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);

        ///////////////////////////



        ////////////////////////////
        RecyclerView fRecyclerView = findViewById(R.id.favorites_list);


        String name = getIntent().getStringExtra("NAME");
        String description = getIntent().getStringExtra("DESCRIPTION");
        int image = getIntent().getIntExtra("IMAGE", 0);

        recipeModels.add(new RecipeModel(name,description,image));

        Breakfast_RecyclerViewAdapter adapter = new Breakfast_RecyclerViewAdapter(this, recipeModels, this);
        fRecyclerView.setAdapter(adapter);
        fRecyclerView.setLayoutManager(new LinearLayoutManager(this));




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