package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import java.io.FileNotFoundException;
import java.util.*;

public class MainActivity extends AppCompatActivity {
    Button manage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Program.ingredientTypes[0] = new Ingredient("onion",0,0);
        Program.ingredientTypes[1] = new Ingredient("garlic",0,0);
        Program.ingredientTypes[2] = new Ingredient("tomatoes",10,8);
        Program.ingredientTypes[3] = new Ingredient("parsley",0,0);
        Program.ingredientTypes[4] = new Ingredient("carrot",10,8);
        Program.ingredientTypes[5] = new Ingredient("potato",10,5);
        Program.ingredientTypes[6] = new Ingredient("mushroom",1,0);
        Program.ingredientTypes[7] = new Ingredient("eggplant",10,5);
        Program.ingredientTypes[8] = new Ingredient("mint",0,0);
        Program.ingredientTypes[9] = new Ingredient("zucchini",0,0);
        Program.ingredientTypes[10] = new Ingredient("broccoli",0,0);
        Log.d("ingList",Program.ingredientTypes[4].toString());
        IngViewModel viewModel = new ViewModelProvider(this).get(IngViewModel.class);
        manage = findViewById(R.id.button);

        manage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchActivities();

            }
        });

    }

    private void switchActivities(){
        Intent x = new Intent(this, CurrentIngredientsActivity.class);
        startActivity(x);
    }


}