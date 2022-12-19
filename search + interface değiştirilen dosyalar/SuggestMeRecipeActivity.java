package com.example.finalcookit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.finalcookit.Program;

import java.util.ArrayList;
/*
* 0 egg salad
* 1 menemen
* 2 mercimek
* 3 spagetti
* 4 meatbals
* 5 chicken saute
*
* */



public class SuggestMeRecipeActivity extends AppCompatActivity implements  RecyclerViewInterface{
    static ArrayList<RecipeModel> recipeModels = new ArrayList<>();
    int[] images = {R.drawable.eggsalad, R.drawable.menemen,R.drawable.mercimeksoup, R.drawable.lunchspagetti,R.drawable.meatballs, R.drawable.chickensaute};

    static  ArrayList<RecipeModel> cook = new ArrayList<>();
    static  ArrayList<RecipeModel> sugge = new ArrayList<>();

    Button goMarket;

    ArrayList<Integer> integersOfCookableWithCurrents = new ArrayList<>();
    int integerOfRecipeCookableWithExtras;
    String url;
    TextView cookableWithCurrentRecipeDetail;
    TextView cookableWithExtraRecipeDetail;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_suggest_me_recipe);

        cookableWithCurrentRecipeDetail = findViewById(R.id.suggestMeRecipeText);
        //cookableWithExtraRecipeDetail = findViewById()



        setUpRecipeModels();

        if(!Program.cookableWithExtras.isEmpty()){
            integerOfRecipeCookableWithExtras = recipeToInteger(Program.cookableWithExtras.get(0));
            sugge.add(recipeModels.get(integerOfRecipeCookableWithExtras));
            url = Program.cookableWithExtras.get(0).getURLofMissingIngToCookThis();
        }

        if(!Program.cookableWithCurrents.isEmpty()){
            for(int i = 0; i<Program.cookableWithCurrents.size();i++){
                integersOfCookableWithCurrents.add(recipeToInteger(Program.cookableWithCurrents.get(i)));
            }
            for(int k = 0; k<integersOfCookableWithCurrents.size() ; k++){
                cook.add(recipeModels.get(integersOfCookableWithCurrents.get(k)));
            }
        }


        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                cookableWithCurrentRecipeDetail.setText(Program.toStringCookableWithCurrents());
                //cookableWithExtraRecipeDetail.setText();
            }
        });






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
                Intent goMarket = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
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

        public int recipeToInteger(Recipe recipe){

            if(recipe.getName().equalsIgnoreCase("egg salad")){
                return 0;
            }
            else if(recipe.getName().equalsIgnoreCase("menemen")){
                return 1;
            }
            else if(recipe.getName().equalsIgnoreCase("mercimek soup")){
                return 2;
            }
            else if(recipe.getName().equalsIgnoreCase("Easy Spaghetti Recipe")){
                return 3;
            }
            else if(recipe.getName().equalsIgnoreCase("Meatballs")){
                return 4;
            }
            else{
                return 5;
            }

        }



}