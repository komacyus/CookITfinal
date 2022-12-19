package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class IngredientEditActivity extends AppCompatActivity {

    Button butter, carrot, chicken, cucumber, egg, eggplant, flour, garlic, greenpepper, lemon, meat, milk, mushroom, oliveoil, onion,redlentil,redpepper, spagetti, potato, rice, tomatoes,tomatopaste;
    EditText butter_E, carrot_E, chicken_E, cucumber_E, egg_E, eggplant_E, flour_E, garlic_E, greenpepper_E, lemon_E, meat_E, milk_E, mushroom_E, oliveoil_E, onion_E,redlentil_E,redpepper_E, spagetti_E, potato_E, rice_E, tomatoes_E,tomatopaste_E;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingredient_edit);
        IngViewModel viewModel = new ViewModelProvider(this).get(IngViewModel.class);
        butter = findViewById(R.id.editInventoryEditButton_butter);
        butter_E = findViewById(R.id.editInventoryEditText_butter);
        butter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double amount = Double.valueOf(butter_E.getText().toString());
                String name = "Butter";
                CIngredient c = new CIngredient(name,amount);
                viewModel.insertIngredient(c);
            }
        });

        carrot = findViewById(R.id.editInventoryEditButton_carrot);
        carrot_E = findViewById(R.id.editInventoryEditText_carrot);
        carrot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double amount = Double.valueOf(carrot_E.getText().toString());
                String name = "Carrot";
                CIngredient c = new CIngredient(name,amount);
                viewModel.insertIngredient(c);
            }
        });

        chicken = findViewById(R.id.editInventoryEditButton_chicken);
        chicken_E = findViewById(R.id.editInventoryEditText_chicken);
        chicken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double amount = Double.valueOf(chicken_E.getText().toString());
                String name = "Chicken";
                CIngredient c = new CIngredient(name,amount);
                viewModel.insertIngredient(c);
            }
        });
        cucumber = findViewById(R.id.editInventoryEditButton_cucumber);
        cucumber_E = findViewById(R.id.editInventoryEditText_cucumber);
        cucumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double amount = Double.valueOf(cucumber_E.getText().toString());
                String name = "Cucumber";
                CIngredient c = new CIngredient(name,amount);
                viewModel.insertIngredient(c);
            }
        });
        egg = findViewById(R.id.editInventoryEditButton_egg);
        egg_E = findViewById(R.id.editInventoryEditText_egg);
        egg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double amount = Double.valueOf(egg_E.getText().toString());
                String name = "Egg";
                CIngredient c = new CIngredient(name,amount);
                viewModel.insertIngredient(c);
            }
        });
        eggplant = findViewById(R.id.editInventoryEditButton_eggplant);
        eggplant_E = findViewById(R.id.editInventoryEditText_eggplant);
        eggplant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double amount = Double.valueOf(eggplant_E.getText().toString());
                String name = "Eggplant";
                CIngredient c = new CIngredient(name,amount);
                viewModel.insertIngredient(c);
            }
        });
        flour = findViewById(R.id.editInventoryEditButton_flour);
        flour_E = findViewById(R.id.editInventoryEditText_flour);
        flour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double amount = Double.valueOf(flour_E.getText().toString());
                String name = "Flour";
                CIngredient c = new CIngredient(name,amount);
                viewModel.insertIngredient(c);
            }
        });
        garlic = findViewById(R.id.editInventoryEditButton_garlic);
        garlic_E = findViewById(R.id.editInventoryEditText_garlic);
        garlic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double amount = Double.valueOf(garlic_E.getText().toString());
                String name = "Garlic";
                CIngredient c = new CIngredient(name,amount);
                viewModel.insertIngredient(c);
            }
        });
        greenpepper = findViewById(R.id.editInventoryEditButton_greenpepper);
        greenpepper_E = findViewById(R.id.editInventoryEditText_greenpepper);
        greenpepper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double amount = Double.valueOf(greenpepper_E.getText().toString());
                String name = "Green_Pepper";
                CIngredient c = new CIngredient(name,amount);
                viewModel.insertIngredient(c);
            }
        });
        lemon = findViewById(R.id.editInventoryEditButton_lemon);
        lemon_E = findViewById(R.id.editInventoryEditText_lemon);
        lemon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double amount = Double.valueOf(lemon_E.getText().toString());
                String name = "Lemon";
                CIngredient c = new CIngredient(name,amount);
                viewModel.insertIngredient(c);
            }
        });
        meat = findViewById(R.id.editInventoryEditButton_meat);
        meat_E = findViewById(R.id.editInventoryEditText_meat);
        meat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double amount = Double.valueOf(meat_E.getText().toString());
                String name = "Meat";
                CIngredient c = new CIngredient(name,amount);
                viewModel.insertIngredient(c);
            }
        });
        milk = findViewById(R.id.editInventoryEditButton_milk);
        milk_E = findViewById(R.id.editInventoryEditText_milk);
        milk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double amount = Double.valueOf(milk_E.getText().toString());
                String name = "Milk";
                CIngredient c = new CIngredient(name,amount);
                viewModel.insertIngredient(c);
            }
        });
        mushroom = findViewById(R.id.editInventoryEditButton_mushroom);
        mushroom_E = findViewById(R.id.editInventoryEditText_mushroom);
        mushroom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double amount = Double.valueOf(mushroom_E.getText().toString());
                String name = "Mushroom";
                CIngredient c = new CIngredient(name,amount);
                viewModel.insertIngredient(c);
            }
        });
        oliveoil = findViewById(R.id.editInventoryEditButton_oliveoil);
        oliveoil_E = findViewById(R.id.editInventoryEditText_oliveoil);
        oliveoil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double amount = Double.valueOf(oliveoil_E.getText().toString());
                String name = "Olive_Oil";
                CIngredient c = new CIngredient(name,amount);
                viewModel.insertIngredient(c);
            }
        });
        onion = findViewById(R.id.editInventoryEditButton_onion);
        onion_E = findViewById(R.id.editInventoryEditText_onion);
        onion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double amount = Double.valueOf(onion_E.getText().toString());
                String name = "Onion";
                CIngredient c = new CIngredient(name,amount);
                viewModel.insertIngredient(c);
            }
        });
        redlentil = findViewById(R.id.editInventoryEditButton_redlentil);
        redlentil_E = findViewById(R.id.editInventoryEditText_redlentil);
        redlentil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double amount = Double.valueOf(redlentil_E.getText().toString());
                String name = "Red_Lentil";
                CIngredient c = new CIngredient(name,amount);
                viewModel.insertIngredient(c);
            }
        });
        redpepper = findViewById(R.id.editInventoryEditButton_redpepper);
        redpepper_E = findViewById(R.id.editInventoryEditText_redpepper);
        redpepper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double amount = Double.valueOf(redpepper_E.getText().toString());
                String name = "Red_Pepper";
                CIngredient c = new CIngredient(name,amount);
                viewModel.insertIngredient(c);
            }
        });
        spagetti = findViewById(R.id.editInventoryEditButton_spagetti);
        spagetti_E = findViewById(R.id.editInventoryEditText_pasta);
        spagetti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double amount = Double.valueOf(spagetti_E.getText().toString());
                String name = "Spaghetti";
                CIngredient c = new CIngredient(name,amount);
                viewModel.insertIngredient(c);
            }
        });
        potato = findViewById(R.id.editInventoryEditButton_potato);
        potato_E = findViewById(R.id.editInventoryEditText_potato);
        potato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double amount = Double.valueOf(potato_E.getText().toString());
                String name = "Potato";
                CIngredient c = new CIngredient(name,amount);
                viewModel.insertIngredient(c);
            }
        });
        rice = findViewById(R.id.editInventoryEditButton_rice);
        rice_E = findViewById(R.id.editInventoryEditText_rice);
        rice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double amount = Double.valueOf(rice_E.getText().toString());
                String name = "Rice";
                CIngredient c = new CIngredient(name,amount);
                viewModel.insertIngredient(c);
            }
        });
        tomatoes = findViewById(R.id.editInventoryEditButton_tomatoes);
        tomatoes_E = findViewById(R.id.editInventoryEditText_tomatoes);
        tomatoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double amount = Double.valueOf(tomatoes_E.getText().toString());
                String name = "Tomato";
                CIngredient c = new CIngredient(name,amount);
                viewModel.insertIngredient(c);
            }
        });
        tomatopaste =findViewById(R.id.editInventoryEditButton_tomatopaste);
        tomatopaste_E =findViewById(R.id.editInventoryEditText_tomatopaste);
        tomatopaste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double amount = Double.valueOf(tomatopaste_E.getText().toString());
                String name = "Tomato_Paste";
                CIngredient c = new CIngredient(name,amount);
                viewModel.insertIngredient(c);
            }
        });
    }
}