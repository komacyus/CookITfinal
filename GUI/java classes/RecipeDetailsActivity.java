package com.a.cookit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.a.cookit.Listeners.RecipeDetailsListener;

import java.util.ArrayList;

public class RecipeDetailsActivity extends AppCompatActivity {

    int pos;
    ArrayList<String> blist;
    TextView textView_meal_name, textView_meal_source, textView_meal_summary, textView_meal_instructions;
    ImageView imageView_meal_image;


    ProgressDialog dialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_details);

        blist = (ArrayList<String>) getIntent().getStringArrayListExtra("array");
        findViews();
        // converting id to int
        //id = Integer.parseInt(getIntent().getStringExtra("id"));
        /*manager = new RequestManager(this);
        manager.getRecipeDetails(recipeDetailsListener, id);
        manager.getInstructions(instructionsListener, id);*/
        textView_meal_name.setText(blist.get(Integer.parseInt(getIntent().getStringExtra("pos"))));
        dialog = new ProgressDialog(this);
        dialog.setTitle("Loading Details...");
        dialog.show();
    }

    private void findViews() {
        textView_meal_name = findViewById(R.id.textView_meal_name);

        textView_meal_summary = findViewById(R.id.textView_meal_summary);
        imageView_meal_image = findViewById(R.id.imageView_meal_image);
        textView_meal_instructions= findViewById(R.id.textView_meal_instructions);
    }

    private final RecipeDetailsListener recipeDetailsListener = new RecipeDetailsListener(){

        @Override
        public void didFetch(ArrayList<String> array, String message) {
            dialog.dismiss();
            textView_meal_name.setText(array.get(Integer.parseInt(blist.get(Integer.parseInt(getIntent().getStringExtra("pos"))))));

            //textView_meal_source.setText(response.sourceName);
            //textView_meal_summary.setText(response.summary);
            //getting images
            //Picasso.get().load(response.image).into(imageView_meal_image);

            /*recycler_meal_ingredients.setHasFixedSize(true);
            recycler_meal_ingredients.setLayoutManager(new LinearLayoutManager(RecipeDetailsActivity.this, LinearLayoutManager.HORIZONTAL, false));
            ingredientsAdapter = new IngredientsAdapter(RecipeDetailsActivity.this, response.extendedIngredients);
            recycler_meal_ingredients.setAdapter(ingredientsAdapter);*/
        }

        @Override
        public void didError(String message) {
            Toast.makeText(RecipeDetailsActivity.this, message, Toast.LENGTH_SHORT).show();

        }
    };


}