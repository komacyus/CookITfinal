package com.a.cookit;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class RecipeDetailsActivity extends AppCompatActivity {


    TextView textView_meal_name, textView_meal_summary;
    ImageView imageView_meal_image;
    ImageButton imageButton;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_details);

        String name = getIntent().getStringExtra("NAME");
        String description = getIntent().getStringExtra("DESCRIPTION");
        int image = getIntent().getIntExtra("IMAGE", 0);
        findViews();

        textView_meal_name.setText(name);
        textView_meal_summary.setText(description);
        imageView_meal_image.setImageResource(image);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( RecipeDetailsActivity.this, FavoritesActivity.class);
                intent.putExtra("NAME", name);
                intent.putExtra("DESCRIPTION", description);
                intent.putExtra("IMAGE",image);
                startActivity(intent);
            }
        });


    }

    private void findViews() {
        textView_meal_name = findViewById(R.id.textView_meal_name);
        imageButton = findViewById(R.id.recipeDetails_imageButton);
        textView_meal_summary = findViewById(R.id.textView_meal_summary);
        imageView_meal_image = findViewById(R.id.imageView_meal_image);

    }




}