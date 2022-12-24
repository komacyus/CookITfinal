package com.example.finalcookit;

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
        //String[] dinnerRecipeNames = getResources().getStringArray(R.array.dinnerRecipesNames_txt);
       // String[] dinnerRecipeDescription = getResources().getStringArray(R.array.dinnerRecipesDescription);
        String[] dinnerRecipeNames ={" Chicken Saute","Meatball"};
        String[] dinnerRecipeDescription ={" Chicken Saute\n"+

                "*1 kg chicken\n"+
                "*1 unit red_pepper\n"+
                "*1 unit green_pepper\n"+
                "*1 unit onion\n"+
                "*5 tablespoon olive_oil\n"+
                "*0.5 glass water\n"+

                "Put the olive oil to the saucepan and then add the cubed cut chicken breasts. Saute them at medium heat about 3 minutes. Add sliced onions, garlic and continue to saute all until onions get softy.\n"+
                "Add the julienne cut red, orange and green sweet peppers, ground paprika and saute them about 7 minutes until sweet peppers get softy.\n"+
                "Add the soy sauce and continue to stir all about 2-3 minutes. Then add the 1/2 cup of water and close the saucepan lid and let it cook 20 minutes at low-medium heat.\n"
                ,"Meatballs\n"+

                "*800 gram ground_beef\n"+
                "*2 unit onion\n"+
                "*2 teaspoon salt\n"+
                "*1 teaspoon black_pepper\n"+
                "*1 over 4 glass water\n"+
                "*1 teaspoon baking soda\n"+

                "1. Get a small onion or some shallots cooking in oil. Once they have softened, let them cool -- they will be going in your meatballs.\n"+
                "2. In a large bowl, mix up the ground meat  with your cooled onions, tomato paste, cheese,  breadcrumbs (I use panko), a splash of milk, and an egg. If it feels too wet, add more breadcrumbs and/or cheese. I love a ton of cheese, to be candid. If you have some parsley or oregano and people who do not balk at green in their meatballs, you may chop a bit up and add it.\n"+
                "3. Make balls in your hand about the size of two golf balls into one. Please keep them uniform so they cook evenly.\n"+
                "4. Refill your frying pan with a enough oil to cover the balls halfway. Get it going till shimmering. (Alternately, you can simmer the balls in your sauce.) Add the balls one at a time. Do not crowd them. You may well have to do this in batches.\n"+
                "5.  Nudge them around the pan with a spatula from time to time. The key here is to keep them from burning, but also to cook them all the way through. You will end up with some that are more crispy than others but just try to control the heat. Pick a sentinel meatball to test for doneness. This should take about ten minutes.\n"+
                "Serve\n"};
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