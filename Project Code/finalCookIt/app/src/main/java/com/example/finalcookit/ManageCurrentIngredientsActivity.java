package com.example.finalcookit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class ManageCurrentIngredientsActivity extends AppCompatActivity {
    Button editButton;
    EditText butter_E, carrot_E, chicken_E, cucumber_E, egg_E, eggplant_E, flour_E, garlic_E, greenpepper_E, lemon_E, meat_E, milk_E, mushroom_E, oliveoil_E, onion_E,redlentil_E,redpepper_E, spagetti_E, potato_E, rice_E, tomatoes_E,tomatopaste_E;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_current_ingredients);
        IngViewModel viewModel = new ViewModelProvider(this).get(IngViewModel.class);
        butter_E = findViewById(R.id.inventoryEditText_butter);
        carrot_E = findViewById(R.id.inventoryEditText_carrot);
        chicken_E = findViewById(R.id.inventoryEditText_chicken);
        cucumber_E = findViewById(R.id.inventoryEditText_cucumber);
        egg_E = findViewById(R.id.inventoryEditText_egg);
        eggplant_E = findViewById(R.id.inventoryEditText_eggplant);
        flour_E = findViewById(R.id.inventoryEditText_flour);
        garlic_E = findViewById(R.id.inventoryEditText_garlic);
        greenpepper_E = findViewById(R.id.inventoryEditText_greenpepper);
        lemon_E = findViewById(R.id.inventoryEditText_lemon);
        meat_E = findViewById(R.id.inventoryEditText_meat);
        milk_E = findViewById(R.id.inventoryEditText_milk);
        mushroom_E = findViewById(R.id.inventoryEditText_mushroom);
        oliveoil_E = findViewById(R.id.inventoryEditText_oliveoil);
        onion_E = findViewById(R.id.inventoryEditText_onion);
        redlentil_E = findViewById(R.id.inventoryEditText_redlentil);
        redpepper_E = findViewById(R.id.inventoryEditText_redpepper);
        spagetti_E = findViewById(R.id.inventoryEditText_spagetti);
        potato_E = findViewById(R.id.inventoryEditText_potato);
        rice_E = findViewById(R.id.inventoryEditText_rice);
        tomatoes_E = findViewById(R.id.inventoryEditText_tomato);
        tomatopaste_E =findViewById(R.id.inventoryEditText_tomatopaste);
        viewModel.getList().observe(this,list1 ->{
            Program.currIngredients = new ArrayList<CurrentIngredient>();

            for(CIngredient c: list1){
                if(c.num != 0){
                    Program.currIngredients.add(Program.converter(c));
                }

                if(c.name.equals("Butter")){
                    butter_E.setText(Double.toString(c.num));
                }
                if(c.name.equals("Carrot")){
                    carrot_E.setText(Double.toString(c.num));
                }
                if(c.name.equals("Chicken")){
                    chicken_E.setText(Double.toString(c.num));
                }
                if(c.name.equals("Cucumber")){
                    cucumber_E.setText(Double.toString(c.num));
                }
                if(c.name.equals("Egg")){
                    egg_E.setText(Double.toString(c.num));
                }
                if(c.name.equals("Eggplant")){
                    eggplant_E.setText(Double.toString(c.num));
                }
                if(c.name.equals("Flour")){
                    flour_E.setText(Double.toString(c.num));
                }
                if(c.name.equals("Garlic")){
                    garlic_E.setText(Double.toString(c.num));
                }
                if(c.name.equals("Green_Pepper")){
                    greenpepper_E.setText(Double.toString(c.num));
                }
                if(c.name.equals("Lemon")){
                    lemon_E.setText(Double.toString(c.num));
                }
                if(c.name.equals("Meat")){
                    meat_E.setText(Double.toString(c.num));
                }
                if(c.name.equals("Milk")){
                    milk_E.setText(Double.toString(c.num));
                }
                if(c.name.equals("Mushroom")){
                    mushroom_E.setText(Double.toString(c.num));
                }
                if(c.name.equals("Olive_Oil")){
                    oliveoil_E.setText(Double.toString(c.num));
                }
                if(c.name.equals("Onion")){
                    onion_E.setText(Double.toString(c.num));
                }
                if(c.name.equals("Red_Lentil")){
                    redlentil_E.setText(Double.toString(c.num));
                }
                if(c.name.equals("Red_Pepper")){
                    redpepper_E.setText(Double.toString(c.num));
                }
                if(c.name.equals("Spaghetti")){
                    spagetti_E.setText(Double.toString(c.num));
                }
                if(c.name.equals("Potato")){
                    potato_E.setText(Double.toString(c.num));
                }
                if(c.name.equals("Rice")){
                    rice_E.setText(Double.toString(c.num));
                }
                if(c.name.equals("Tomato")){
                    tomatoes_E.setText(Double.toString(c.num));
                }
                if(c.name.equals("Tomato_Paste")){
                    tomatopaste_E.setText(Double.toString(c.num));
                }
            }
            for(CurrentIngredient curr: Program.currIngredients){
                Log.d("Debug", curr.getIngredient().toString() + " " + curr.getInputTypeAmount());
            }

        });


        editButton = findViewById(R.id.inventoryEditButton);

        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goEditPage = new Intent(ManageCurrentIngredientsActivity.this, IngredientEditActivity.class);
                startActivity(goEditPage);
            }
        });
    }
}