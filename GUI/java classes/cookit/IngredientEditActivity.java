package com.a.cookit;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;

public class IngredientEditActivity extends AppCompatActivity {

    Button butter, carrot, chicken, cucumber, egg, eggplant, flour, garlic, lemon, meat, milk, mushroom, oliveoil, onion, spagetti, potato, rice, tomatoes;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingredient_edit);

        butter = findViewById(R.id.editInventoryEditButton_butter);
        carrot = findViewById(R.id.editInventoryEditButton_carrot);
        chicken = findViewById(R.id.editInventoryEditButton_chicken);
        cucumber = findViewById(R.id.editInventoryEditButton_cucumber);
        egg = findViewById(R.id.editInventoryEditButton_egg);
        eggplant = findViewById(R.id.editInventoryEditButton_eggplant);
        flour = findViewById(R.id.editInventoryEditButton_flour);
        garlic = findViewById(R.id.editInventoryEditButton_garlic);
        lemon = findViewById(R.id.editInventoryEditButton_lemon);
        meat = findViewById(R.id.editInventoryEditButton_meat);
        milk = findViewById(R.id.editInventoryEditButton_milk);
        mushroom = findViewById(R.id.editInventoryEditButton_mushroom);
        oliveoil = findViewById(R.id.editInventoryEditButton_oliveoil);
        onion = findViewById(R.id.editInventoryEditButton_onion);
        spagetti = findViewById(R.id.editInventoryEditButton_spagetti);
        potato = findViewById(R.id.editInventoryEditButton_potato);
        rice = findViewById(R.id.editInventoryEditButton_rice);
        tomatoes = findViewById(R.id.editInventoryEditButton_tomatoes);





    }
}