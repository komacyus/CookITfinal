package com.example.finalcookit;

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
        //String[] breakfastRecipeNames = getResources().getStringArray(R.array.breakfastRecipesNames_txt);
        //String[] breakfastRecipeDescription = getResources().getStringArray(R.array.breakfastRecipesDescription);
        String[] breakfastRecipeNames = {"Egg Salad", "Menemen"};
        String[] breakfastRecipeDescription= {"Egg Salad\n"+
                "*3 unit egg\n"+
            "*2 unit green_onion\n"+
           " *2 unit parsley\n"+
            "*4 tablespoon olive_oil\n"+
            "*1 unit lemon\n"+
            "*2 tablespoon salt\n"+
            "*1 unit red_pepper\n"+
            "*1 unit green_pepper\n"+



            "-Put the eggs in a small saucepan. Cover with water to 1 inch above eggs. Boil eggs. Remove from heat. Drain the water of boiled eggs. Then, leave to cool eggs.\n"+
               "-Peel the boiled eggs. Chop the way you want.\n"+
                "-Put chopped eggs into a serving dish. Add the finely chopped parsley, dill, green onions, mint, olive oil, salt and black pepper. Mix thoroughly.\n"+
            "-Serve\n",
                    "Menemen\n"+

               "*1 tablespoon olive_oil\n"+
"*1 unit onion\n"+
"*1 unit green_pepper\n"+
"*1 tablespoon butter\n"+
"*4 unit tomato\n"+
"*4 unit egg\n"+
            "- Heat oil in a large sauté pan over medium-high heat.  Add onion and peppers and sauté for 5 minutes, stirring occasionally, until softened.\n"+
                "-Reduce heat to medium.  Add the tomatoes, butter plus a generous pinch of salt and black pepper.  Stir until evenly combined, then sauté for 2 more minutes, until the tomatoes are nice and hot.\n"+
            "-Crack the eggs on top of the tomato mixture.  Let the eggs cook for about 1 minute.  Then use a spoon to break the yolks and briefly stir the eggs into the tomato mixture. Continue cooking until the eggs reach your desired level of doneness.\n"+
                "-Serve immediately with your desired garnishes, along with some crusty sliced bread for dipping.\n"};


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